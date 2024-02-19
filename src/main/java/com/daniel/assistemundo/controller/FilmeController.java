package com.daniel.assistemundo.controller;

import com.daniel.assistemundo.model.Analise;
import com.daniel.assistemundo.model.Filme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmeController {
    
    private List<Filme> listaFilmes = new ArrayList<>();
    private List<Analise> listaAnalises = new ArrayList<>();
    
    @GetMapping("/inicio")
    public String inicio() {
        return "index";
    }
    
    @GetMapping("/cadastrarFilme")
    public String cadastrarFilme(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastro_filmes";
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(Model model, @ModelAttribute Filme filme) {
        filme.setId(listaFilmes.size() + 1);
        listaFilmes.add(filme);
        return "redirect:/listar";
    }
    
    @GetMapping("/listar")
    public String listagem(Model model) {
        model.addAttribute("lista", listaFilmes);
        return "listagem";
    }
    
    @GetMapping("/detalhes")
    public String detalhesFilme(@RequestParam String id, Model model) {
       Integer idFilme = Integer.parseInt(id);
       
       Filme filmeEscolhido = new Filme();
       
       for(Filme f: listaFilmes){
           if(f.getId()==idFilme){
               filmeEscolhido = f;
               break;
           }
        }
       
       
       List<Analise> analisesEncontradas = new ArrayList<>();
       for(Analise a : listaAnalises) {
           if(a.getFilme().getId() == idFilme) {
           analisesEncontradas.add(a);
       }
       }
       
       model.addAttribute("filme", filmeEscolhido);
       model.addAttribute("analise", new Analise());
       model.addAttribute("analises", analisesEncontradas);
       
       
       return "detalhes";
    }
    
    @PostMapping("/gravar-analise")
    public String processarAnalise(Model model, @ModelAttribute Analise analise, @ModelAttribute Filme filme) {
        analise.setId(listaAnalises.size() + 1);
        analise.setFilme(filme);
        listaAnalises.add(analise);
        return "redirect:/listar";
    }
}
