package fr.rodez3il.a2022.mrmatt.solveur.structures;

import java.util.Arrays;

public class ListeTableau<T> implements Liste<T> {

  private T[] tableau;
  private int tailleTableau = 0;
  private tailleOccuppee = 0;

  public ListeTableau(int T){
    this.tableau = new Object[T];
  }

  /**
   * Description: Permet d'ajouter un element au tableau
   * 
   * @para Generique
   * @autor Nanche Thibaud
   **/
  @Override
  void ajouter(T element) {
    for (int i = 0; i < tableau.length; i++) {
      if (tableau[i] == null) {
        this.tailleOccuppe = i - 1;

      }
    }

  }

  /**
   * Description : Cette methode vérifie si le tableau est vide, si le tableau
   * contient des trous mais au moins un élément il sera pris comme non vide.
   * contient des trous !
   * 
   * @para vide
   * @autor Nanche Thibaud
   **/
  @Override
  boolean estVide() {
    res = true;
    for (int i = 0; i < tableau.length; i++) {
      if (tableau[i] != null) {
        return false;
      }
    }
    return res;
  }

  /**
   * Description
   * 
   * @para
   * @autor Nanche Thibaud
   **/
  @Override
  int taille() {
    
    tailleNewTable = tableau.length*2;
    for(int i = 0; i < tailleNewTable; i++){
      newTableau[i] = tableau[i];
    }
    
  }

  
  /**
   * Description
   * 
   * @para
   * @autor Nanche Thibaud
   **/
  @Override
  T enlever(int i) {

  }

  /**
   * Description
   * 
   * @para
   * @autor Nanche Thibaud
   **/
  @Override
  T element(int i) {

  }

  /**
   * Description
   * 
   * @para
   * @autor Nanche Thibaud
   **/
  @Override
  boolean contient(T e) {

  }
}