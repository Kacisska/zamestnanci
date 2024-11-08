package cz.mojeprace;
import java.util.Scanner;
public class Main {

    private static Scanner scanner = new Scanner(System.in, "UTF-8");


    // Instance třídy EvidenceZamestnanych pro správu pojištěnců
    private static EvidenceZamestnancu evidenceZamestnancu = new EvidenceZamestnancu();

    public static void main(String[] args) {
        String volba;
        // Hlavní cyklus programu - opakuje se, dokud uživatel nezvolí možnost "5"
        do {
            vypisMenu(); // Výpis hlavního menu
            volba = scanner.nextLine().trim(); // Načtení volby uživatele, odstranění přebytečných mezer
            zpracujVolbu(volba); // Zpracování volby uživatele
        } while (!volba.equals("5"));
    }


    // Metoda pro výpis hlavního menu
    private static void vypisMenu() {
        System.out.println("-------------------------\nEvidence zaměstnanců\n-------------------------");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového zaměstnance");
        System.out.println("2 - Vypsat všechny zaměstnance");
        System.out.println("3 - Vyhledat zaměstnance");
        System.out.println("4 - Smazat zaměstnance");
        System.out.println("5 - Konec");
    }


    // Metoda pro zpracování volby uživatele
    private static void zpracujVolbu(String volba) {
        switch (volba) {
            case "1":
                // Přidání nového pojištěnce
                pridejZamestnance(); // Přidání nového pojištěnce
                break;
            case "2":
                // Výpis všech zaměstnanců
                evidenceZamestnancu.vypisZamestnance();
                cekejNaPokracovani(); // Čekání na uživatele před pokračováním
                break;
            case "3":
                // Vyhledání zaměstnance podle jména a příjmení
                vyhledejZamestnance();
                cekejNaPokracovani();
                break;
            case "4":
                // Smazání zaměstnance
                smazZamestnance();
                break;
            case "5":
                // Ukončení programu
                System.out.println("Děkujeme za Váš čas.");
                break;
            default:
                // Ošetření neplatné volby
                System.out.println("Tato volba neexistuje.");
        }
    }


    // Metoda pro naformátování jména a příjmneí tak, aby počáteční písmena byla ve výpisu a hledání zaměstnance velká (i když je uživatel zadá s počátečními malými písmeny)
    private static String naformatujJmenoNeboPrijmeni(String vstup) {
        if (vstup == null || vstup.isEmpty()) {
            return vstup; // Vrátí původní hodnotu, pokud je vstup null nebo prázdný
        }
        // První písmeno na velké a zbytek na malé
        return vstup.substring(0, 1).toUpperCase() + vstup.substring(1).toLowerCase();
    }


    // Metoda pro načtení vstupu od uživatele
    private static String nactiVstup(String zprava) {
        System.out.println(zprava); // Výpis zprávy pro uživatele
        return scanner.nextLine().trim(); // Načtení vstupu uživatele a odstranění přebytečných mezer
    }


    // Metoda pro přidání nového pojištěnce
    private static void pridejZamestnance() {
        String jmeno = naformatujJmenoNeboPrijmeni(nactiNeplatnyVstup("Zadejte jméno zaměstnance:")); // Načtení jména
        String prijmeni = naformatujJmenoNeboPrijmeni(nactiNeplatnyVstup("Zadejte příjmení zaměstnance:")); // Načtení příjmení
        String telefon = nactiNeplatnyVstup("Zadejte telefonní číslo:"); // Načtení telefonního čísla
        int vek = Integer.parseInt(nactiNeplatnyVstup("Zadejte věk:")); // Načtení věku a převod na celé číslo

        evidenceZamestnancu.pridejZamestnance(jmeno, prijmeni, vek, telefon); // Přidání zaměstnance do evidence
        System.out.println("Data byla uložena. Pokračujte libovolnou klávesou...");
        scanner.nextLine();
    }


    // Metoda pro vyhledání zaměstnance podle jména a příjmení
    private static void vyhledejZamestnance() {
        String hledanejmeno = naformatujJmenoNeboPrijmeni(nactiVstup("Zadejte jméno zaměstnance:")); // Načtení hledaného jména
        String hledaneprijmeni = naformatujJmenoNeboPrijmeni(nactiVstup("Zadejte příjmení zaměstnance:"));  // Načtení hledaného příjmení

        Zamestnanec nalezenyZamestnanec = evidenceZamestnancu.vyhledejZamestnance(hledanejmeno, hledaneprijmeni);
        if (nalezenyZamestnanec != null) {
            System.out.println(nalezenyZamestnanec); // Výpis nalezeného zaměstnance
        } else {
            System.out.println("Zaměstnanec nebyl nalezen.");
        }
    }


    // Metoda pro načtení vstupu od uživatele, který nesmí být prázdný
    private static String nactiNeplatnyVstup(String zprava) {
        String vstup;
        do {
            vstup = nactiVstup(zprava);
            if (vstup.isEmpty()) {
                System.out.println("Chyba: Pole nesmí být prázdné.");
            }
        } while (vstup.isEmpty());
        return vstup;
    }

    private static void smazZamestnance() {
        String jmeno = naformatujJmenoNeboPrijmeni(nactiVstup("Zadejte jméno zaměstnance ke smazání:"));
        String prijmeni = naformatujJmenoNeboPrijmeni(nactiVstup("Zadejte příjmení zaměstnance ke smazání:"));
        evidenceZamestnancu.smazZamestnance(jmeno, prijmeni);
        System.out.println("Pokračujte libovolnou klávesou...");
        scanner.nextLine();
    }



    // Metoda pro čekání na pokračování uživatele po stisknutí libovolné klávesy
    private static void cekejNaPokracovani() {
        System.out.println("Pokračujte libovolnou klávesou.");
        scanner.nextLine();
    }
}

