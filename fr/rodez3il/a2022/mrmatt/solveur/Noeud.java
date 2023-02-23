package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;
import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeTableau;

import fr.rodez3il.a2022.mrmatt.Commande;
import fr.rodez3il.a2022.mrmatt.Niveau;

public class Noeud {

    private final DictionnaireChaine<String, Noeud> conf;
    private final Niveau etatNiveau;
    private final ListeTableau<Noeud> tableau_fils;
    private final String cmd;
    private boolean EstVisite;
    private String solution;
    private String suiteCommandes;
    private String donneesChaine;

    public Noeud(DictionnaireChaine<String, Noeud> configuration, Niveau etatDuNiveau, String commandes) {
        this.conf = configuration;
        this.etatNiveau = etatDuNiveau;
        this.tableau_fils = new ListeTableau<>();
        this.cmd = commandes;
    }

    public boolean estVisite() {
        return EstVisite;
    }

    public ListeTableau<Noeud> getTableau_fils() {
        return tableau_fils;
    }

    public void ajouterFils(Noeud fils) {
        if (fils != null) {
            this.tableau_fils.ajouter(fils);
        }
    }

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

    public String calculerFils() {
        EstVisite = true;
        conf.inserer(etatNiveau.valeurChaine(), this);
        for (Commande commande : Commande.values()) {
            if (etatNiveau.deplacementPossible(commande) && etatNiveau.enCours()) {
                suiteCommandes = cmd + " " + commande;
                Niveau nouvelEtat = etatNiveau.copier();
                nouvelEtat.deplacer(commande);
                nouvelEtat.calcule();
                boolean gagnant = nouvelEtat.estGagnant();
                if (gagnant) {
                    solution = suiteCommandes;
                    return solution;
                } else {
                    donneesChaine = nouvelEtat.valeurChaine();
                    if (conf.contient(donneesChaine)) {
                        ajouterFils(conf.valeur(donneesChaine));
                    } else {
                        Noeud filsNoeud = new Noeud(conf, nouvelEtat, suiteCommandes);
                        ajouterFils(filsNoeud);
                        filsNoeud.calculerFils();
                    }
                }
            }
        }
        return null;
    }

}
/***
 La classe Noeud représente un nœud dans un arbre de recherche.
 Les nœuds contiennent un état du jeu, une liste de nœuds enfants, une chaîne de commandes pour atteindre cet état
 et une référence à un dictionnaire qui mappe des chaînes d'état à des nœuds.

 Les méthodes et les champs publics de la classe Noeud sont les suivants :

 DictionnaireChaine<String, Noeud> conf : le dictionnaire utilisé pour stocker les nœuds.
 Niveau etat : l'état du jeu représenté par ce nœud.
 ListeTableau<Noeud> fils : la liste des nœuds enfants de ce nœud.
 String commandes : la chaîne de commandes utilisée pour atteindre cet état.
 boolean visite : un indicateur pour savoir si ce nœud a déjà été visité ou pas.
 String solution : la chaîne de commandes pour résoudre le jeu, si ce nœud représente un état gagnant.
 String suiteCommandes : la chaîne de commandes pour atteindre l'état représenté par ce nœud.
 String valChaine : la chaîne de l'état représenté par le nœud.
 Noeud(DictionnaireChaine<String, Noeud> config, Niveau etat, String commandes) : le constructeur de la classe Noeud.
 boolean estVisite() : retourne true si ce nœud a déjà été visité, false sinon.
 ListeTableau<Noeud> getFils() : retourne la liste des nœuds enfants de ce nœud.
 void ajouterFils(Noeud fils) : ajoute le nœud fils à la liste des nœuds enfants de ce nœud.
 boolean equals(Object obj) : retourne true si l'objet obj est égal à ce nœud, false sinon.
 String calculerFils() : calcule les nœuds enfants de ce nœud et retourne la chaîne de commandes pour résoudre
 le jeu si ce nœud représente un état gagnant, null sinon.
 La méthode calculerFils() est la plus importante de la classe Noeud.
 Elle calcule les nœuds enfants de ce nœud en parcourant toutes les commandes possibles et en créant de nouveaux
 nœuds pour chaque nouvel état du jeu résultant de l'application d'une commande.
 Si l'un des nouveaux nœuds représente un état gagnant, la méthode retourne la chaîne de commandes pour résoudre
 le jeu. Si tous les nouveaux nœuds représentent des états non gagnants, la méthode retourne null.
 La méthode utilise également le dictionnaire pour éviter de créer des nœuds pour des états qui ont déjà été visités.
 ***/
