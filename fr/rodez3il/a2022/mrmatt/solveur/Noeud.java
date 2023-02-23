package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;
import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeTableau;

import fr.rodez3il.a2022.mrmatt.Commande;
import fr.rodez3il.a2022.mrmatt.Niveau;

/**
 * @author Nanche Thibaud
 * Cette classe représente un noeud dans un arbre de recherche utilisé pour résoudre un problème.
 */
public class Noeud {

    /**
     * @author Nanche Thibaud
     * Le dictionnaire qui associe une chaîne de caractères à un objet Noeud
     */
    private final DictionnaireChaine<String, Noeud> conf;

    /**
     * L'état du niveau associé à ce noeud
     */
    private final Niveau etatNiveau;

    /**
     * La liste des fils de ce noeud
     */
    private final ListeTableau<Noeud> tableau_fils;

    /**
     * La séquence de commandes pour atteindre ce noeud
     */
    private final String cmd;

    /**
     * Indique si ce noeud a été visité pendant la recherche
     */
    private boolean EstVisite;

    /**
     * La séquence de commandes pour résoudre le problème à partir de ce noeud
     */
    private String solution;

    /**
     * La séquence de commandes pour atteindre ce noeud
     */
    private String suiteCommandes;

    /**
     * La représentation sous forme de chaîne de l'état du niveau associé à ce noeud
     */
    private String donneesChaine;

    /**
     * @author Nanche Thibaud
     * Constructeur de la classe Noeud.
     *
     * @param configuration le dictionnaire associant une chaîne de caractères à un objet Noeud
     * @param etatDuNiveau  l'état du niveau associé à ce noeud
     * @param commandes     la séquence de commandes pour atteindre ce noeud
     */
    public Noeud(DictionnaireChaine<String, Noeud> configuration, Niveau etatDuNiveau, String commandes) {
        this.conf = configuration;
        this.etatNiveau = etatDuNiveau;
        this.tableau_fils = new ListeTableau<>();
        this.cmd = commandes;
    }

    /**
     * @author Nanche Thibaud
     * Indique si ce noeud a été visité pendant la recherche.
     *
     * @return true si ce noeud a été visité, false sinon
     */
    public boolean estVisite() {
        return EstVisite;
    }

    /**
     * @author Nanche Thibaud
     * Retourne la liste des fils de ce noeud.
     *
     * @return la liste des fils de ce noeud
     */
    public ListeTableau<Noeud> getTableau_fils() {
        return tableau_fils;
    }

    /**
     * @author Nanche Thibaud
     * Ajoute un fils à la liste des fils de ce noeud.
     *
     * @param fils le fils à ajouter
     */
    public void ajouterFils(Noeud fils) {
        if (fils != null) {
            this.tableau_fils.ajouter(fils);
        }
    }

    /**
     * @author Nanche Thibaud
     * Vérifie si ce noeud est égal à un autre objet.
     *
     * @param obj l'objet à comparer
     * @return true si ce noeud est égal à l'objet, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Noeud other = (Noeud) obj;
        return etatNiveau.equals(other.etatNiveau) && tableau_fils.equals(other.tableau_fils) && cmd.equals(other.cmd)
                && conf.equals(other.conf);
    }
}
