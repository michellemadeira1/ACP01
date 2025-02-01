package br.com.ehmf.AppProdutos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppProdutos.model.Produtos;
import br.com.ehmf.AppProdutos.repository.ProdutosRepository;

@RestController
@RequestMapping("/api")
public class AppProdutosResource {
	
    @Autowired
	private ProdutosRepository produtosRepository;
	
    
	@GetMapping("lista")
	public List<Produtos> listar(){
		List<Produtos> listProdutos = produtosRepository.findAll();
		return listProdutos;
	}
    
	@GetMapping
	public String getApi() {
		return "API Java funcionando! 😎😎";
	}
	
	@GetMapping("getProduto")
	public Produtos getProduto() {
		Produtos produto = new Produtos();
		produto.setCodigoBarras("5646465446");
		produto.setNome("Monitor LG");
		produto.setPreco(1000.0);
		
		System.out.println(produto);
		
		return produto;
	}
	
	@GetMapping("getProdutos")
	public List<Produtos> getProdutos(){
		List<Produtos> listProdutos = new ArrayList<Produtos>();
		
		Produtos produto1 = new Produtos();
		produto1.setCodigoBarras("6565464646589");
		produto1.setNome("Monitor AOC");
		produto1.setPreco(2000.0);
		listProdutos.add(produto1);
		
		Produtos produto2 = new Produtos();
		produto2.setCodigoBarras("987646546");
		produto2.setNome("Fone JBL");
		produto2.setPreco(200.0);
		listProdutos.add(produto2);
		
		Produtos produto3 = new Produtos();
		produto3.setCodigoBarras("987646546");
		produto3.setNome("Mouse JBL");
		produto3.setPreco(100.0);
		listProdutos.add(produto3);
		
		return listProdutos;
	}
	
	
	
}
