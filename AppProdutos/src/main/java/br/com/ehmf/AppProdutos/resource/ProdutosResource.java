package br.com.ehmf.AppProdutos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ehmf.AppProdutos.model.Produtos;
import br.com.ehmf.AppProdutos.service.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosResource {
	
	@Autowired
	private ProdutosService produtosService;

	@PostMapping
	public ResponseEntity <Produtos> save(@RequestBody Produtos produto) {
		Produtos newProduto = produtosService.save(produto);
		if(newProduto == null) {
		return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(newProduto);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produtos>> findById(@PathVariable Long id){
		Optional<Produtos> produto =produtosService.findById(id);
		if(produto.isEmpty()) {
			return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(produto);
			}
	}
	
	@GetMapping
	public ResponseEntity<List<Produtos>>findAll(){
		List<Produtos> produtos = produtosService.findAll();
		if(produtos == null) 
			return ResponseEntity.badRequest().build();
		if(produtos.size()== 0) 
			return ResponseEntity.notFound().build();
			return ResponseEntity.ok(produtos);
	}
	
	@PutMapping
	public ResponseEntity<Produtos>update(Produtos produto){
		Produtos updProduto = produtosService.update(produto);
		if(updProduto == null) {
			return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(updProduto);
			}
	}
	
	@DeleteMapping
	public ResponseEntity<?>delete(@PathVariable Long id){
		produtosService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
