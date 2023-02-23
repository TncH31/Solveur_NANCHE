package fr.rodez3il.a2022.mrmatt.solveur.test;
import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeTableau;


import org.junit.Test;
import static org.junit.Assert.*;
/**
 *@autor Nanche Thibaud
 * Teste la classe ListeTableau
 */
public class TestListeTableau {
    /**
     *@autor Nanche Thibaud
     * Teste la méthode Ajouter()
     */
    @Test
    public void testAjouter() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        liste.ajouter(1);
        liste.ajouter(2);
        liste.ajouter(3);
        assertEquals(3, liste.taille());
        assertEquals(1, (int) liste.element(0));
        assertEquals(2, (int) liste.element(1));
        assertEquals(3, (int) liste.element(2));
    }
    /**
     *@autor Nanche Thibaud
     * Teste la méthode Redimensionne()
     */
    @Test
    public void testRedimensionner() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        for (int i = 0; i < 11; i++) {
            liste.ajouter(i);
        }
        assertEquals(11, liste.taille());
        assertEquals(0, (int) liste.element(0));
        assertEquals(10, (int) liste.element(10));
    }
    /**
     *@autor Nanche Thibaud
     * Teste la méthode EstVide()
     */
    @Test
    public void testEstVide() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        assertTrue(liste.estVide());
        liste.ajouter(1);
        assertFalse(liste.estVide());
    }
    /**
     *@autor Nanche Thibaud
     * Teste la méthode taille()
     */
    @Test
    public void testTaille() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        assertEquals(0, liste.taille());
        liste.ajouter(1);
        assertEquals(1, liste.taille());
        liste.ajouter(2);
        assertEquals(2, liste.taille());
    }
    /**
     *@autor Nanche Thibaud
     * Teste la méthode Enlever()
     */
    @Test
    public void testEnlever() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        liste.ajouter(1);
        liste.ajouter(2);
        liste.ajouter(3);
        int elementSupprime = liste.enlever(1);
        assertEquals(2, elementSupprime);
        assertEquals(2, liste.taille());
        assertEquals(1, (int) liste.element(0));
        assertEquals(3, (int) liste.element(1));
    }
    /**
     *@autor Nanche Thibaud
     * Teste IndexOutOfBounds()
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEnleverIndexOutOfBounds() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        liste.enlever(0);
    }
    /**
     *@autor Nanche Thibaud
     * Teste Element()
     */
    @Test
    public void testElement() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        liste.ajouter(1);
        liste.ajouter(2);
        liste.ajouter(3);
        assertEquals(2, (int) liste.element(1));
    }
    /**
     *@autor Nanche Thibaud
     * Teste IndexOutOfBounds ()
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testElementIndexOutOfBounds() {
        ListeTableau<Integer> liste = new ListeTableau<>();
        liste.element(0);
    }
    /**
     *@autor Nanche Thibaud
     * Teste la méthode testContient()
     */
    @Test
    public void testContient() {
        ListeTableau<String> liste = new ListeTableau<>();
        liste.ajouter("abc");
        liste.ajouter("def");
        assertTrue(liste.contient("abc"));
        assertTrue(liste.contient("def"));
        assertFalse(liste.contient("ghi"));
    }
}

