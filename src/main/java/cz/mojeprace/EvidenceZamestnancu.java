package cz.mojeprace;

import java.util.ArrayList;
import java.util.Scanner;
public class EvidenceZamestnancu {

    private final ArrayList<Zamestnanec> seznamZamestnancu = new ArrayList<>(); // seznam k uložení zaměstnanců

private final Scanner scanner = new Scanner(System.in); //vstup pro uživatele

public void pridejZamestnance(String jmeno, String prijmeni, int vek, String telefon) { //metoda pro přidání nového zaměstnance

    seznamZamestnancu.add(new Zamestnanec(jmeno, prijmeni, vek, telefon)); //přidání nového zamědstnance do seznamu zaměstnanců
}

public void vypisZamestnance() { //metoda pro výpis všech zamestnanců

    if (seznamZamestnancu.isEmpty()) {//kontrola seznamu zaměstnanců, zda není prázdný
        System.out.println("Neexistují žádní zaměstnanci.");

    } else {
        System.out.println("Seznam všech zaměstnanců:");
        for (Zamestnanec zamestnanec : seznamZamestnancu) {
            System.out.println(zamestnanec);
        }
    }

}

public Zamestnanec vyhledejZamestnance(String hledanejmeno, String hledaneprijmeni) {// metoda pro vyhledání zaměstnance

    for (Zamestnanec zamestnanec : seznamZamestnancu) { // prochází seznam zaměstnanců
        if (zamestnanec.getJmeno().equalsIgnoreCase(hledanejmeno) && zamestnanec.getPrijmeni().equalsIgnoreCase(hledaneprijmeni))
        { //kontrola, zda se jméno a příjmení shodují
            return zamestnanec; //vrátí nalezeného zaměstnance
        }
    }
    return null;
}

public void smazZamestnance(String jmeno, String prijmeni) { //metoda pro smazání zaměstnance
    Zamestnanec zamestnanec = vyhledejZamestnance(jmeno, prijmeni);
    if (zamestnanec != null) {
    seznamZamestnancu.remove(zamestnanec);
    System.out.println("Zaměstnanec byl úspěšně smazán.");
} else {
        System.out.println("Zaměstnanec nebyl nalezen.");
    }
    }
    }
