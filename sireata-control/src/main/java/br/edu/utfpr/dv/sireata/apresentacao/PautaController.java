/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dv.sireata.apresentacao;

import br.edu.utfpr.dv.sireata.dao.PautaDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PautaController {
    
    private final PautaDAO pautaDAO;
    
    PautaController() {
        this.pautaDAO = new PautaDAO();
    }
            
    @GetMapping("/pauta/ata/{id}")
    public List<Pauta> lista(@PathVariable(value = "id") int id) {
        try {
            Pauta pauta = new Pauta();
            pautaDAO.salvar(pauta);
            List<Pauta> lista = pautaDAO.listarPorAta(id);
            return lista;
        } catch(SQLException ex) {
            return null;
        }
    }
    
    @PostMapping("/pauta")
    public HttpStatus criar(Pauta pauta) {
        
        try {
            pautaDAO.salvar(pauta);
        } catch (SQLException ex) {
            Logger.getLogger(PautaController.class.getName()).log(Level.SEVERE, null, ex);
            return HttpStatus.CREATED;
        }
        
        return HttpStatus.CREATED;
    }
}
