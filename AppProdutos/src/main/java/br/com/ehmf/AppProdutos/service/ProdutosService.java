package br.com.ehmf.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.model.Produtos;
import br.com.ehmf.AppProdutos.repository.ProdutosRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	
	public Produtos save(Produtos produto) {
		if(produto.getNome()== null) {
			System.out.println("Nome do produto vazio");
			return null;
		}
		if(produto.getCodigoBarras()== null) {
			System.out.println("Codigo de barras do produto vazio");
			return null;
		}
		try {
			return produtosRepository.save(produto);
		}catch(Exception e) {
			System.out.println("Erro ao inserir o produto" + produto.toString() +e.getMessage());
		}
		return produto;	
	}
	
	public Optional<Produtos> findById(Long id){
		return produtosRepository.findById(id);
	}
	
	public List<Produtos> findAll(){
		return produtosRepository.findAll();
	}
	
	public Produtos update(Produtos produto) {
		Optional<Produtos> findProduto = produtosRepository.findById(produto.getId());
		if(findProduto.isPresent()) {
			Produtos updProduto = findProduto.get();
			updProduto.setNome(produto.getNome());
			updProduto.setCodigoBarras(produto.getCodigoBarras());
			updProduto.setPreco(produto.getPreco());
			return produtosRepository.save(updProduto);
		}	
		return produtosRepository.save(produto);
	}
	
	public void delete(Long id) {
		produtosRepository.deleteById(id);
	}

}
