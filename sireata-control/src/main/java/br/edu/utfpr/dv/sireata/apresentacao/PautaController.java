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
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PautaController {
    
    private final PautaDAO pautaDAO;
    
    PautaController() {
        this.pautaDAO = new PautaDAO();
    }
            
    @GetMapping("/pauta/{id}")
    public List<Pauta> listaPautas(@PathVariable(value = "id") int id) {
        try {
            Pauta pauta = new Pauta();
            pautaDAO.salvar(pauta);
            return pautaDAO.listarPorAta(1);
        } catch(SQLException ex) {
            return null;
        }
    }
}
