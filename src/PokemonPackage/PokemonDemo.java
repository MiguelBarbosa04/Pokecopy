package PokemonPackage;

import enums.TiposEnum;

public class PokemonDemo {
        public void criarPokemons() {
                Pokemon bulbasaur = new Pokemon("Bulbasaur",
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.POISON },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.ICE, TiposEnum.FLYING, TiposEnum.PSYCHIC },
                                55, 40, 35);

                Pokemon charmander = new Pokemon("Charmander",
                                new TiposEnum[] { TiposEnum.FIRE },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.GROUND }, 60, 35, 39);

                Pokemon squirtle = new Pokemon("Squirtle",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS }, 50, 65, 44);

                Pokemon pikachu = new Pokemon("Pikachu",
                                new TiposEnum[] { TiposEnum.ELECTRIC },
                                new TiposEnum[] { TiposEnum.GROUND }, 55, 40, 35);

                Pokemon jigglypuff = new Pokemon("Jigglypuff",
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FAIRY },
                                new TiposEnum[] { TiposEnum.POISON, TiposEnum.STEEL }, 45, 20, 115);

                Pokemon geodude = new Pokemon("Geodude",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND,
                                                TiposEnum.STEEL },
                                80, 100, 40);

                Pokemon gastly = new Pokemon("Gastly",
                                new TiposEnum[] { TiposEnum.GHOST, TiposEnum.POISON },
                                new TiposEnum[] { TiposEnum.GROUND, TiposEnum.PSYCHIC, TiposEnum.GHOST }, 35, 30, 30);

                Pokemon onix = new Pokemon("Onix",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND,
                                                TiposEnum.STEEL },
                                45, 160, 35);

                Pokemon alakazam = new Pokemon("Alakazam",
                                new TiposEnum[] { TiposEnum.PSYCHIC },
                                new TiposEnum[] { TiposEnum.BUG, TiposEnum.GHOST, TiposEnum.DARK }, 120, 45, 55);

                Pokemon machamp = new Pokemon("Machamp",
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] { TiposEnum.FLYING, TiposEnum.PSYCHIC, TiposEnum.FAIRY }, 100, 85, 90);

                Pokemon gyarados = new Pokemon("Gyarados",
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.FLYING },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.ROCK }, 125, 79, 95);

                Pokemon dragonite = new Pokemon("Dragonite",
                                new TiposEnum[] { TiposEnum.DRAGON, TiposEnum.FLYING },
                                new TiposEnum[] { TiposEnum.ICE, TiposEnum.DRAGON, TiposEnum.FAIRY }, 134, 95, 91);

                Pokemon meowth = new Pokemon("Meowth",
                                new TiposEnum[] { TiposEnum.NORMAL },
                                new TiposEnum[] { TiposEnum.FIGHTING }, 45, 35, 40);

                Pokemon psyduck = new Pokemon("Psyduck",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS }, 52, 48, 50);

                Pokemon machop = new Pokemon("Machop",
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] { TiposEnum.FLYING, TiposEnum.PSYCHIC, TiposEnum.FAIRY }, 70, 50, 70);

                Pokemon poliwag = new Pokemon("Poliwag",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS }, 50, 40, 40);

                Pokemon growlithe = new Pokemon("Growlithe",
                                new TiposEnum[] { TiposEnum.FIRE },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.GROUND }, 70, 45, 55);

                Pokemon seel = new Pokemon("Seel",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS }, 65, 55, 65);

                Pokemon omanyte = new Pokemon("Omanyte",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.ELECTRIC }, 40, 100, 70);

                Pokemon kabuto = new Pokemon("Kabuto",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.BUG },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.FIGHTING }, 40, 80, 60);

        }

}
