package cz.mojeprace;

import java.util.Scanner;

public class Zamestnanec {

    /**
     * Jméno zaměstnance.
     */
    private final String jmeno;

    /**
     * Příjmení zaměstnance.
     */
    private final String prijmeni;

    /**
     * Věk zaměstnance.
     */
    private final int vek;

    /**
     * Telefonní číslo zaměstnance.
     */
    private final String telefon;

    /**
     * Konstruktor třídy Zamestnanec.
     * Inicializuje objekt zaměstnance s uvedeným jménem, příjmením, věkem a telefonním číslem.
     *
     * @param jmeno
     * @param prijmeni
     * @param vek
     * @param telefon
     */
    public Zamestnanec(String jmeno, String prijmeni, int vek, String telefon) {
        // Inicializace atributů objektu
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = validatePhoneNumber(telefon);

    }

    private String validatePhoneNumber(String telefon) {
        Scanner scanner = new Scanner(System.in);

        // odstranění mezer
        telefon = telefon.replace(" ", "");

        // cyklus pro zajištění, že telefon má přesně 9 číslic
        while (telefon.length() != 9) {
            System.out.println("Telefonní číslo musí obsahovat přesně 9 číslic. Zadejte znovu:");
            telefon = scanner.nextLine().replace(" ", ""); // odstraní mezery a znovu načte číslo
        }
        return telefon;
    }


    /**
     * Metoda toString() vrací textovou reprezentaci objektu zaměstnance.
     * Používá formátování, aby zarovnala jednotlivé části výpisu do sloupců.
     *
     * @return Textová reprezentace zaměstnance
     */
    @Override
    public String toString() {
        return String.format("%-15s %-15s %4d %15s", jmeno, prijmeni, vek, telefon);
    }

    /**
     * Getter pro jméno zaměstnance.
     *
     * @return Jméno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Getter pro příjmení zaměstnance.
     *
     * @return Příjmení
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Getter pro věk zaměstnance.
     *
     * @return Věk
     */
    public int getVek() {
        return vek;
    }

    /**
     * Getter pro telefonní číslo zaměstnance.
     *
     * @return Telefonní číslo
     */
    public String getTelefon() {

        return telefon;
    }

    }