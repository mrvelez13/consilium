package com.plurality.platform.webflux.app;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.plurality.platform.webflux.app.models.dao.IProductoDao;
import com.plurality.platform.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableWebFlux
@EnableReactiveMongoRepositories
public class SpringBootWebfluxApplication implements CommandLineRunner
{
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("productos").subscribe();
		
		Flux.just(new Producto("TV Panasonic Pantalla LCD", 456.89),
				new Producto("Sony Camara HD Digital", 500.62),
				new Producto("Computador Portatil Dell LATITUDE 960", 322.30)
				)
		.flatMap(producto -> {
			producto.setCreateAt(new Date());
			return productoDao.save(producto);
			
		})
		.subscribe(producto -> log.info("Insert: {} {}", producto.getId(), producto.getNombre()));		
	}
}
