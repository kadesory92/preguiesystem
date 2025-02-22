package banatech.gn.preguie_blogservice.utils;

import java.util.function.Function;

public class SlugUtil {

    public static String generateSlug(String input) {
        if (input == null) {
            return null;
        }
        // Convertir en minuscules
        String slug = input.toLowerCase();
        // Remplacer les espaces par des tirets
        slug = slug.replaceAll("\\s+", "-");
        // Supprimer les caractères spéciaux
        slug = slug.replaceAll("[^a-z0-9-]", "");
        // Supprimer les tirets multiples
        slug = slug.replaceAll("-+", "-");
        // Supprimer les tirets en début et fin
        slug = slug.replaceAll("^-|-$", "");
        return slug;
    }

    public static String createUniqueNameSlug(String baseSlug, Function<String, Boolean> slugExistsChecker) {
        String slug = baseSlug;
        int suffix = 1;

        // Vérifier si le slug existe déjà
        while (slugExistsChecker.apply(slug)) {
            slug = baseSlug + "-" + suffix; // Ajouter un suffixe numérique
            suffix++;
        }

        return slug;
    }
}
