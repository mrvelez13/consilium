package com.plurality.platform.webflux.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plurality.platform.webflux.app.models.dao.IProductoDao;
import com.plurality.platform.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController
{
	@Autowired
	private IProductoDao productoDao;
	
	private static final Logger log = LoggerFactory.getLogger(ProductoCotroller.class);
	
	@GetMapping
	public Flux<Producto> index()
	{
		return  productoDao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto; 
		}).doOnNext(prod -> log.info(prod.getNombre()));		
	}
	
	@GetMapping("/{id}")
	public Mono<Producto> show(@PathVariable String id)
	{
		return productoDao.findById(id);
	}
}
