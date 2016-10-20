/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import principal.Principal;

/**
 *
 * @author administrador
 */
public class Testador 
{
    public static void main(String[] args) throws IOException 
    {
        //Principal p = new Principal();
        //p.replicaTestadora("Entrada/A-n33-k5.vrp");
        try ( Stream<Path> paths = Files.walk(Paths.get("/home/administrador/Documentos/Metaheurística/Implementação/instances-CVRP/Augerat/A-VRP")))
        {
            paths.forEach( filePath -> 
            {
                if ( Files.isRegularFile(filePath))
                {
                    //filePath.
                    System.out.println(filePath.getFileName());
                    
                }
            });
        }
        
    }
}
