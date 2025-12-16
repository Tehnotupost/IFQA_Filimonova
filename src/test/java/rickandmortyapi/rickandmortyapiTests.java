package rickandmortyapi;

import api.rickandmortyapi.CharacterApi;
import api.rickandmortyapi.EpisodeApi;
import constants.CharacterConst;
import constants.EpisodeConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class rickandmortyapiTests extends WebHooks {

// тут немножко переменных потом добавим

    @Test
    @DisplayName("Последний эпизод с Морти")
    void checkLastEpisodeWithMorty() {
        CharacterConst morty = CharacterApi.getCharacterInfo(2)
                .extract()
                .as(CharacterConst.class);
        System.out.println("Морти Смит: " + morty.getName());
        System.out.println("Статус: " + morty.getStatus());
        System.out.println("Количество эпизодов: " + morty.getEpisode().size());
        String lastEpisodeUrl = morty.getEpisode().get(morty.getEpisode().size() - 1);
        int lastEpisodeId = Integer.parseInt(lastEpisodeUrl.substring(lastEpisodeUrl.lastIndexOf("/") + 1));
        System.out.println("Последний: " + lastEpisodeUrl);
        EpisodeConst lastEpisode = EpisodeApi.getEpisodeById(lastEpisodeId)
                .extract()
                .as(EpisodeConst.class);
        System.out.println("Название: " + lastEpisode.getName());
        System.out.println("Вышел: " + lastEpisode.getAir_date());
        System.out.println("Количество персонажей: " + lastEpisode.getCharacters().size());
    }

    @Test
    @DisplayName("Последний персонаж последнего эпизода")
    void checkLastCharacterOfLastEpisodeWithMorty() {
        CharacterConst morty = CharacterApi.getCharacterInfo(2)
                .extract()
                .as(CharacterConst.class);
        String lastEpisodeUrl = morty.getEpisode().get(morty.getEpisode().size() - 1);
        int lastEpisodeId = Integer.parseInt(lastEpisodeUrl.substring(lastEpisodeUrl.lastIndexOf("/") + 1));
        EpisodeConst lastEpisode = EpisodeApi.getEpisodeById(lastEpisodeId)
                .extract()
                .as(EpisodeConst.class);
        System.out.println("Название: " + lastEpisode.getName());
        System.out.println("Количество персонажей: " + lastEpisode.getCharacters().size());
        String lastCharacterUrl = lastEpisode.getCharacters().get(lastEpisode.getCharacters().size() - 1);
        System.out.println("Ссыль на перса: " + lastCharacterUrl);
        int lastCharacterId = Integer.parseInt(lastCharacterUrl.substring(lastCharacterUrl.lastIndexOf("/") + 1));
        CharacterConst lastCharacter = CharacterApi.getCharacterInfo(lastCharacterId)
                .extract()
                .as(CharacterConst.class);
        System.out.println("Последний перс: " + lastCharacter.getName());
        System.out.println("Статус: " + lastCharacter.getStatus());
    }

    @Test
    @DisplayName("Местонахождение и раса последнего персонажа")
    void checkLocationAndTypeLastCharacter() {
        CharacterConst morty = CharacterApi.getCharacterInfo(2)
                .extract()
                .as(CharacterConst.class);
        String lastEpisodeUrl = morty.getEpisode().get(morty.getEpisode().size() - 1);
        int lastEpisodeId = Integer.parseInt(lastEpisodeUrl.substring(lastEpisodeUrl.lastIndexOf("/") + 1));
        EpisodeConst lastEpisode = EpisodeApi.getEpisodeById(lastEpisodeId)
                .extract()
                .as(EpisodeConst.class);
        String lastCharacterUrl = lastEpisode.getCharacters().get(lastEpisode.getCharacters().size() - 1);
        int lastCharacterId = Integer.parseInt(lastCharacterUrl.substring(lastCharacterUrl.lastIndexOf("/") + 1));
        CharacterConst lastCharacter = CharacterApi.getCharacterInfo(lastCharacterId)
                .extract()
                .as(CharacterConst.class);
        System.out.println("Последний перс: " + lastCharacter.getName());
        String lastCharacterLoc = lastCharacter.getLocation().getName();
        System.out.println("Лока: " + lastCharacterLoc);
        String lastCharacterSpecies = lastCharacter.getSpecies();
        System.out.println("Раса: " + lastCharacterSpecies);
    }

    @Test
    @DisplayName("Местонахождение и раса последнего персонажа. Сравнение с Морти")
    void compareLocationAndTypeLastCharacterWithMorty() {
        CharacterConst morty = CharacterApi.getCharacterInfo(2)
                .extract()
                .as(CharacterConst.class);
        System.out.println("Морти Смит: " + morty.getName());
        String mortyLoc = morty.getLocation().getName();
        System.out.println("Лока: " + mortyLoc);
        String mortySpecies = morty.getSpecies();
        System.out.println("Раса: " + mortySpecies);
        String lastEpisodeUrl = morty.getEpisode().get(morty.getEpisode().size() - 1);
        int lastEpisodeId = Integer.parseInt(lastEpisodeUrl.substring(lastEpisodeUrl.lastIndexOf("/") + 1));
        EpisodeConst lastEpisode = EpisodeApi.getEpisodeById(lastEpisodeId)
                .extract()
                .as(EpisodeConst.class);
        String lastCharacterUrl = lastEpisode.getCharacters().get(lastEpisode.getCharacters().size() - 1);
        int lastCharacterId = Integer.parseInt(lastCharacterUrl.substring(lastCharacterUrl.lastIndexOf("/") + 1));
        CharacterConst lastCharacter = CharacterApi.getCharacterInfo(lastCharacterId)
                .extract()
                .as(CharacterConst.class);
        System.out.println("Последний перс: " + lastCharacter.getName());
        String lastCharacterLoc = lastCharacter.getLocation().getName();
        System.out.println("Лока: " + lastCharacterLoc);
        String lastCharacterSpecies = lastCharacter.getSpecies();
        System.out.println("Раса: " + lastCharacterSpecies);

    }
}
