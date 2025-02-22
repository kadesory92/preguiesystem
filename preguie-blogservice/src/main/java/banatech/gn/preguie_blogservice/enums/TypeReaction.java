package banatech.gn.preguie_blogservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeReaction {
    LIKE(0, "Like", "J'aime"),
    LOVE(1, "Love", "Amour"),
    ANGRY(2, "Angry", "En colère"),
    WOW(3, "Wow", "Waouh"),
    SAD(4, "Sad", "Triste"),
    APPRECIATIVE(5, "Appreciative", "Reconnaissant"),
    CONFIDENT(6, "Confident", "Confiant"),
    SMILEY(7, "Smiley", "Souriant"),
    ENTHUSIASTIC(8, "Enthusiastic", "Enthousiaste"),
    EXCITED(9, "Excited", "Excité"),
    GLAD(10, "Glad", "Content"),
    HAPPY(11, "Happy", "Heureux"),
    IN_LOVE(12, "In love", "Amoureux"),
    KIND(13, "Kind", "Gentil"),
    PASSIONATE(14, "Passionate", "Passionné"),
    PROUD(15, "Proud", "Fier"),
    SATISFIED(16, "Satisfied", "Satisfait"),
    SURPRISED(17, "Surprised", "Surpris"),
    TOUCHED(18, "Touched", "Touché"),
    AGGRESSIVE(19, "Aggressive", "Agressif"),
    AFRAID(20, "Afraid", "Effrayé"),
    ANNOYED(21, "Annoyed", "Agacé"),
    BITTER(22, "Bitter", "Amer"),
    BORED(23, "Bored", "Ennuyé"),
    DISAPPOINTED(24, "Disappointed", "Déçu"),
    DISPLEASED(25, "Displeased", "Mécontent"),
    DISCOURAGED(26, "Discouraged", "Découragé"),
    EXHAUSTED(27, "Exhausted", "Épuisé"),
    FURIOUS(28, "Furious", "Furieux"),
    IRRITATED(29, "Irritated", "Irrité"),
    JEALOUS(30, "Jealous", "Jaloux"),
    NERVOUS(31, "Nervous", "Nerveux"),
    PESSIMISTIC(32, "Pessimistic", "Pessimiste"),
    SCARED(33, "Scared", "Effrayé"),
    SHOCKED(34, "Shocked", "Choqué"),
    STRESSED(35, "Stressed", "Stressé"),
    TIRED(36, "Tired", "Fatigué"),
    WEARY(37, "Weary", "Lassé"),
    WORRIED(38, "Worried", "Inquiet"),
    LIVELY(39, "Lively", "Vivant");

    private final int value;
    private final String title;
    private final String content;

    TypeReaction(final int value, final String title, String content) {
        this.value = value;
        this.title = title;
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}