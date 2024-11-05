import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.uniza.fri.bojovnici.Lukostrelec;
import sk.uniza.fri.bojovnici.Rytier;
import sk.uniza.fri.hra.Team;

/**
 * Trieda TeamTest.
 *
 * testuje rôzne metody triedy Test
 *
 * @author matus
 */
public class TeamTest {

    @Test
    void testDvakratRovnakeho() {
        Rytier rytier = new Rytier();
        Team team = new Team();
        team.pridajBojovnika(rytier);
        team.pridajBojovnika(rytier);
        Assertions.assertEquals(1, team.dajVelkostTeamu());
    }


    @Test
    void testSiPrazdny() {
        Rytier rytier = new Rytier();
        Team team = new Team();
        team.pridajBojovnika(rytier);
        Assertions.assertFalse(team.siPrazdny());
    }

    @Test
    void testPridajNullBojovnika() {
        Team team = new Team();
        team.pridajBojovnika(null);
        Assertions.assertTrue(team.siPrazdny());
    }

    @Test
    void testVyradeniBojovnici() {
        Team team = new Team();
        team.pridajBojovnika(new Lukostrelec());
        team.odoberBojovnikaZIndexu(0);
        Assertions.assertEquals(1, team.dajVyradenychBojovnikov().size());

    }
}
