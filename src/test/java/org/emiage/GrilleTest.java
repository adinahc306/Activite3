package test.java.org.emiage;

import main.java.org.emiage.Grille;
import main.java.org.emiage.GrilleImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Jérémie
 */
public class GrilleTest {

    /**
     * Constante exprimant un caractère vide.
     */
    static final char VIDE = Grille.EMPTY;
    /**
     * Constante 1.
     */
    static final int UN = 1;
     /**
     * Constante 2.
     */
    static final int DEUX = 2;
     /**
     * Constante 3.
     */
    static final int TROIS = 3;
     /**
     * Constante 4.
     */
    static final int QUATRE = 4;
     /**
     * Constante 5.
     */
    static final int CINQ = 5;
     /**
     * Constante 6.
     */
    static final int SIX = 6;
     /**
     * Constante 7.
     */
    static final int SEPT = 7;
     /**
     * Constante 8.
     */
    static final int HUIT = 8;
     /**
     * Constante 9.
     */
    static final int NEUF = 9;
    /**
     * Notre grille de test.
     */
    static final char[][] TEST_GRILLE
            = {
                {VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, VIDE, VIDE, '3', VIDE, '8', '5'},
                {VIDE, VIDE, '1', VIDE, '2', VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, '5', VIDE, '7', VIDE, VIDE, VIDE},
                {VIDE, VIDE, '4', VIDE, VIDE, VIDE, '1', VIDE, VIDE},
                {VIDE, '9', VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE},
                {'5', VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, '7', '3'},
                {VIDE, VIDE, '2', VIDE, '1', VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, VIDE, '4', VIDE, VIDE, VIDE, '8'}
            };
    /**
     * Test de la méthode getDimension, de la class GrilleImpl.
     */
    @Test
    public final void testGetDimension() {
        System.out.println("Test de la méthode getDimension");
        Grille grillle = new GrilleImpl(TEST_GRILLE);
        int resultat = grillle.getDimension();
        assertEquals(NEUF, resultat);
    }
    /**
     * Test de la méthode setValue, of class Grille.
     */
    @Test
    public final void testSetValue() {
        System.out.println("Test de la méthode setValue");
        Grille grille = new GrilleImpl(TEST_GRILLE);
        grille.setValue(CINQ, DEUX, '5');
    }
    /**
     * Test de la méthode getValue, de la class GrilleImpl.
     */
    @Test
    public final void testGetValue() {
        System.out.println("Test de la méthode getValue");
        Grille grille = new GrilleImpl(TEST_GRILLE);
        char resultat = grille.getValue(SIX, SEPT);
        if (resultat != '7') {
            fail("testGetValue: Valeurs différentes");
        }
    }
    /**
     * Test de la méthode complete, de la class GrilleImpl.
     */
    @Test
    public final void testComplete() {
        System.out.println("Test de la méthode complete");
        Grille grille = new GrilleImpl(TEST_GRILLE);
        boolean resultat = grille.complete();
        assertEquals(false, resultat);
    }
    /**
     * Test de la méthode possible, de la class GrilleImpl.
     */
    @Test
    public final void testPossible() {
        System.out.println("Test de la méthode possible");
        Grille grille = new GrilleImpl(TEST_GRILLE);
        boolean resultat = grille.possible(SEPT, HUIT, '7');
        assertEquals(true, resultat);
    }

    /**
     * Méthode main d'exécution.
     *
     * @param args Arguments à passer
     */
    public static void main(final String[] args) {
        GrilleTest test = new GrilleTest();
        test.testGetDimension();
        test.testGetValue();
        test.testSetValue();
        test.testComplete();
        test.testPossible();
    }

}
