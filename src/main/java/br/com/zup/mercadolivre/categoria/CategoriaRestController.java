package br.com.zup.mercadolivre.categoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/categorias")
public class CategoriaRestController {

    private CategotiaRepository categotiaRepository;

    @PersistenceContext
    EntityManager entityManager;

    public CategoriaRestController(CategotiaRepository categotiaRepository) {
        this.categotiaRepository = categotiaRepository;
    }

    @PostMapping
    @Transactional
    public String criarCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest){
        Categoria categoria = categotiaRepository.save(novaCategoriaRequest.toModel(entityManager));
        return categoria.toString();
    }
}
