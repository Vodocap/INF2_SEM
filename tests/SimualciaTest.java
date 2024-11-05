import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.uniza.fri.bojovnici.Rytier;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.hra.Simulacia;
import sk.uniza.fri.hra.Team;

/**
 * Trieda SimulaciaTest.
 *
 * testuje rôzne metody triedy simulacia
 *
 * @author Matúš Uhlár
 */
public class SimualciaTest {




    @Test
    void testNullVJednomTeame() {
        Simulacia simulacia = new Simulacia();
        Team team = new Team();
        Hrac hrac = new Hrac("fero", 20);
        Assertions.assertFalse(simulacia.spustiBoj(team, null, hrac));
    }

    @Test
    void testPrazdnyTeam() {
        Simulacia simulacia = new Simulacia();
        Team teamJedna = new Team();
        Team teamDva = new Team();
        teamDva.pridajBojovnika(new Rytier());
        Hrac hrac = new Hrac("jano", 20);
        Assertions.assertFalse(simulacia.spustiBoj(teamJedna, teamDva, hrac));

    }

    @Test
    void testNullHrac() {
        Simulacia simulacia = new Simulacia();
        Team team = new Team();
        Team teamDva = new Team();

        Assertions.assertFalse(simulacia.spustiBoj(team, teamDva, null));

    }


}
