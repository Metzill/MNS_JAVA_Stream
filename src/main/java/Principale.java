import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principale {
    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant("bansept", "franck");
        etudiant1.getListeNote().add(new Note("JAVA", 15));
        etudiant1.getListeNote().add(new Note("PHP", 10));
        etudiant1.getListeNote().add(new Note("UML", 5));

        Etudiant etudiant2 = new Etudiant("doe", "simon");
        etudiant2.getListeNote().add(new Note("JAVA", 5));
        etudiant2.getListeNote().add(new Note("PHP", 19));

        Etudiant etudiant3 = new Etudiant("stark", "sansa");
        etudiant3.getListeNote().add(new Note("C#", 5));
        etudiant3.getListeNote().add(new Note("AVA", 18));


        List<Etudiant> listeEtudiant = new ArrayList<>();
        listeEtudiant.add(etudiant1);
        listeEtudiant.add(etudiant2);
        listeEtudiant.add(etudiant3);

        System.out.println('\n');
        System.out.println("Exo1:");
        System.out.println(
                listeEtudiant.stream()
                        .map(s -> s.getNom().toLowerCase(Locale.ROOT) + '.' + s.getPrenom().toLowerCase(Locale.ROOT) + "@ceesi.com")
                        .collect(Collectors.joining(" - ")));

        System.out.println('\n');
        System.out.println("Exo2:");
        System.out.println(listeEtudiant.stream()
                .filter(s -> Objects.equals(s.getPrenom().charAt(0), 's') || Objects.equals(s.getPrenom().charAt(0), 'S') )
                .sorted(Comparator.comparing(s -> -s.getListeNote().stream()
                        .mapToInt(Note::getNote).max().getAsInt()))
                .map( s -> s.getNom() + ' ' + s.getPrenom())
                .findFirst().get());

        System.out.println('\n');
        System.out.println("Exo3:");
        ArrayList<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        listeEtudiant.stream()
                .forEach(s -> s.getListeNote().stream()
                        .forEach(note -> listeEvaluation.add(new Evaluation(s,note.getNote()))));
        listeEvaluation.forEach(evaluation -> System.out.println(evaluation.getPersonne().getNom() + ' ' + evaluation.getPersonne().getPrenom() + ' ' + evaluation.getNote().toString()));

        System.out.println('\n');
        System.out.println("Exo4:");
        System.out.println(
                listeEtudiant.stream()
                        .sorted(Comparator.comparing(personne -> personne.getListeNote().stream()
                                .mapToInt(note -> note.getNote()).average().getAsDouble()))
                        .map(personne ->
                                personne.nom.toUpperCase().charAt(0) + "-" +
                                        personne.prenom.toUpperCase().charAt(0) + " (" +
                                        personne.getListeNote().stream()
                                                .mapToInt(note -> note.getNote()).max().getAsInt() + ")"
                        )
                        .collect(Collectors.joining(" > ")));
    }
}
