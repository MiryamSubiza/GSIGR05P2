/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.Misc;

import GSILabs.BModel.*;
import GSILabs.BSystem.BussinessSystem;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Alex
 */
public class SSTest05 {
    
    private static BussinessSystem bSystem;
    private static Concert[] concerts;
    private static Location[] locations;
    private static Artist[] artists;
    
    public static void main(String[] args) throws IOException{
        
        final File file = new File("P05Ej02.ods");
        bSystem = new BussinessSystem();
        int ticketsOk = bSystem.importTickets(file);
        System.out.println("El numero de tickets introducidos: "+ ticketsOk);
        
    }
    
    // Introduce los eventos necesarios para poder introducir correctamente todos
    // los tickets de la hoja de calculo suministrada en la práctica
    private void introducirDatos() throws IOException{
        
        concerts = new Concert[48];
        locations = new Location[16];
        artists = new Artist[16];
        
        // Introduzco las localizaciones de los eventos
        locations[0] = new Location("Recinto de las minas", 400, "Sevilla", "www.lasminas.es");
        locations[1] = new Location("Palacio Mestalla", 1000, "Valencia", "www.mestalla.es");
        locations[2] = new Location("Palacio de los Deportes", 1000, "Madrid", "www.pdeportes.es");
        locations[3] = new Location("NY Galleries", 1000, "New York", "www.nygalleries.com");
        locations[4] = new Location("Wired Room Harvard", 1000, "Harvard", "www.harvard.com");
        locations[5] = new Location("Brangthurden", 1000, "Berlin", "www.brangthurden.gr");
        locations[6] = new Location("LA Chinease Theatre", 5000, "Los Angeles", "www.chineasetheatre.com");
        locations[7] = new Location("Miami Beach", 50000, "Miami", "www.ultramusic.com");
        locations[8] = new Location("Frankfurt Conference Room", 1000, "Frankfurt", "www.frankfurt.com");
        locations[9] = new Location("Torrowland Festival Solar", 1000, "Holland", "www.tomorrowland.com");
        locations[10] = new Location("Cooper-Hewitt Theatre", 1000, "Boston", "www.cooperhewitt.com");
        locations[11] = new Location("NY Freak Stadium", 1000, "New York", "www.internetweek.com");
        locations[12] = new Location("Apple Theatre", 10000, "New Yord", "www.apple.com");
        locations[13] = new Location("Camp Nou", 10000, "Barcelona", "www.barca.es");
        locations[14] = new Location("Clinton Room Conference", 1000, "Washington", "www.clinton.com");
        locations[15] = new Location("Pirineos Mountains", 1000, "Aragon", "www.pirineo.es");
        
        bSystem.addLocation(locations[0]);
        bSystem.addLocation(locations[1]);
        bSystem.addLocation(locations[2]);
        bSystem.addLocation(locations[3]);
        bSystem.addLocation(locations[4]);
        bSystem.addLocation(locations[5]);
        bSystem.addLocation(locations[6]);
        bSystem.addLocation(locations[7]);
        bSystem.addLocation(locations[8]);
        bSystem.addLocation(locations[9]);
        bSystem.addLocation(locations[10]); 
        bSystem.addLocation(locations[11]);
        bSystem.addLocation(locations[12]);
        bSystem.addLocation(locations[13]);
        bSystem.addLocation(locations[14]);
        bSystem.addLocation(locations[15]);        
                        
        // Introduzco los artistas
        artists[0] = new Artist("El Cigala", "Canta-autor de flamenco");
        artists[1] = new Artist("ACDC", "El mejor grupo Heavy de la historia");
        artists[2] = new Artist("Barack Obama", "Presidente de los EEUU");
        artists[3] = new Artist("Bill Gates", "Creador y director de Microsoft");
        artists[4] = new Artist("Augustus Glup", "Le gusta el chocolara");
        artists[5] = new Artist("Peabody", "Perro con inteligencia humana, considerado el ser mas listo del planeta");
        artists[6] = new Artist("Allesso", "DJ internacional");
        artists[7] = new Artist("La salchicha Frankfurt", "El ser mas delicioso del planeta");
        artists[8] = new Artist("Avicii", "DJ sueco internacional");
        artists[9] = new Artist("Cooper Hewitt", "Un inteligente de este planeta");
        artists[10] = new Artist("Steve Jobs", "Creador de la empresa Apple");
        artists[11] = new Artist("Nerds", "Las personas mas frikis del mundo mundial");
        artists[12] = new Artist("Clinton", "Ex-presidente de los EEUU");
        artists[13] = new Artist("PirineoMan", "El hombre de los pirineos");
        
        bSystem.addArtist(artists[0]);
        bSystem.addArtist(artists[1]);
        bSystem.addArtist(artists[2]);
        bSystem.addArtist(artists[3]);
        bSystem.addArtist(artists[4]);
        bSystem.addArtist(artists[5]);
        bSystem.addArtist(artists[6]);
        bSystem.addArtist(artists[7]);
        bSystem.addArtist(artists[8]);
        bSystem.addArtist(artists[9]);
        bSystem.addArtist(artists[10]);
        bSystem.addArtist(artists[11]);
        bSystem.addArtist(artists[12]);
        bSystem.addArtist(artists[13]);
                
        // Introduzco los eventos
        File f = new File("eventos.ods");
        System.out.println("El numero de conciertos introducidos es: " + bSystem.importConcerts(f));
        
    }
}
