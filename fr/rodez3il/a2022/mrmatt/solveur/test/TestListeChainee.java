package fr.rodez3il.a2022.mrmatt.solveur.test;
import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeChainee;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests unitaires pour la classe ListeChainee.
 *
 * @author Nanche Thibaud
 */
public class TestListeChainee {

    /**
     * @author Nanche Thibaud
     * Teste le constructeur de la liste chaînée.
     */
    @Test
    public void testConstructeur() {
        ListeChainee<Integer> liste = new ListeChainee<>();
        assertTrue(liste.estVide());
        assertEquals(0, liste.taille());
    }

    /**
     * @author Nanche Thibaud
     * Teste la méthode ajouter() de la liste chaînée.
     */
    @Test
    public void testAjouter() {
        ListeChainee<Integer> liste = new ListeChainee<>();
        liste.ajouter(1);
        assertFalse(liste.estVide());
        assertEquals(1, liste.taille());
        assertEquals(Integer.valueOf(1), liste.element(0));

        liste.ajouter(2);
        assertFalse(liste.estVide());
        assertEquals(2, liste.taille());
        assertEquals(Integer.valueOf(2), liste.element(1));
    }

    /**
     * @author Nanche Thibaud
     * Teste la méthode enlever() de la liste chaînée.
     */
    @Test
    public void testEnlever() {
        ListeChainee<Integer> liste = new ListeChainee<>();
        liste.ajouter(1);
        liste.ajouter(2);
        liste.ajouter(3);
        liste.ajouter(4);

        assertEquals(Integer.valueOf(1), liste.enlever(0));
        assertEquals(3, liste.taille());
        assertEquals(Integer.valueOf(2), liste.element(0));

        assertEquals(Integer.valueOf(4), liste.enlever(2));
        assertEquals(2, liste.taille());
        assertEquals(Integer.valueOf(3), liste.element(1));
    }

    /**
     * @author Nanche Thibaud
     * Teste la méthode element() de la liste chaînée.
     */
    @Test
    public void testElement() {
        ListeChainee<Integer> liste = new ListeChainee<>();
        liste.ajouter(1);
        liste.ajouter(2);
        liste.ajouter(3);
        liste.ajouter(4);

        assertEquals(Integer.valueOf(1), liste.element(0));
        assertEquals(Integer.valueOf(2), liste.element(1));
        assertEquals(Integer.valueOf(4), liste.element(3));
    }

    /**
     * @author Nanche Thibaud
     * Teste la méthode contient() de la liste chaînée.
     */
    @Test
    public void testContient() {
        ListeChainee<Integer> liste = new ListeChainee<>();
        liste.ajouter(1);
        liste.ajouter(2);
        liste.ajouter(3);

        assertTrue(liste.contient(1));
        assertTrue(liste.contient(2));
        assertTrue(liste.contient(3));
        assertFalse(liste.contient(4));
    }
}
