package PokemonPackage;

import enums.TiposEnum;

public class PokemonDemo {
        public void criarPokemons() {

                Tecnicas flamethrower = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.FIRE });
                Tecnicas thunderbolt = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.ELECTRIC });
                Tecnicas surf = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.WATER });
                Tecnicas psychic = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.PSYCHIC });
                Tecnicas earthquake = new Tecnicas(100, 100, new TiposEnum[] { TiposEnum.GROUND });
                Tecnicas iceBeam = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.ICE });
                Tecnicas sludgeBomb = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.POISON });
                Tecnicas hyperBeam = new Tecnicas(150, 90, new TiposEnum[] { TiposEnum.NORMAL });
                Tecnicas rockSlide = new Tecnicas(75, 90, new TiposEnum[] { TiposEnum.ROCK });
                Tecnicas shadowBall = new Tecnicas(80, 100, new TiposEnum[] { TiposEnum.GHOST });
                Tecnicas dragonClaw = new Tecnicas(80, 100, new TiposEnum[] { TiposEnum.DRAGON });
                Tecnicas darkPulse = new Tecnicas(80, 100, new TiposEnum[] { TiposEnum.DARK });
                Tecnicas dazzlingGleam = new Tecnicas(80, 100, new TiposEnum[] { TiposEnum.FAIRY });
                Tecnicas aerialAce = new Tecnicas(60, 100, new TiposEnum[] { TiposEnum.FLYING });
                Tecnicas brickBreak = new Tecnicas(75, 100, new TiposEnum[] { TiposEnum.FIGHTING });
                Tecnicas bugBuzz = new Tecnicas(90, 100, new TiposEnum[] { TiposEnum.BUG });
                Tecnicas ironTail = new Tecnicas(100, 75, new TiposEnum[] { TiposEnum.STEEL });
                Tecnicas quickAttack = new Tecnicas(70, 100, new TiposEnum[] { TiposEnum.NORMAL });
                Tecnicas dynamicPunch = new Tecnicas(100, 50, new TiposEnum[] { TiposEnum.FIGHTING });
                Tecnicas slash = new Tecnicas(70, 100, new TiposEnum[] { TiposEnum.NORMAL });

                Pokemon bulbasaur = new Pokemon("Bulbasaur",
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.POISON },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.ICE, TiposEnum.FLYING, TiposEnum.PSYCHIC },
                                55, 40, 35, 20,
                                new Tecnicas[] { sludgeBomb, earthquake });

                Pokemon charmander = new Pokemon("Charmander",
                                new TiposEnum[] { TiposEnum.FIRE },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.GROUND },
                                60, 35, 39, 30,
                                new Tecnicas[] { flamethrower, dragonClaw });

                Pokemon squirtle = new Pokemon("Squirtle",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                50, 65, 44, 24,
                                new Tecnicas[] { surf, iceBeam });

                Pokemon pikachu = new Pokemon("Pikachu",
                                new TiposEnum[] { TiposEnum.ELECTRIC },
                                new TiposEnum[] { TiposEnum.GROUND },
                                55, 40, 35, 50,
                                new Tecnicas[] { thunderbolt, quickAttack });

                Pokemon jigglypuff = new Pokemon("Jigglypuff",
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FAIRY },
                                new TiposEnum[] { TiposEnum.POISON, TiposEnum.STEEL },
                                45, 20, 115, 32,
                                new Tecnicas[] { hyperBeam, dazzlingGleam });

                Pokemon geodude = new Pokemon("Geodude",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND, TiposEnum.STEEL },
                                80, 100, 40, 19,
                                new Tecnicas[] { rockSlide, earthquake });

                Pokemon gastly = new Pokemon("Gastly",
                                new TiposEnum[] { TiposEnum.GHOST, TiposEnum.POISON },
                                new TiposEnum[] { TiposEnum.GROUND, TiposEnum.PSYCHIC, TiposEnum.GHOST },
                                35, 30, 30, 31,
                                new Tecnicas[] { shadowBall, sludgeBomb });

                Pokemon onix = new Pokemon("Onix",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND, TiposEnum.STEEL },
                                45, 160, 35, 20,
                                new Tecnicas[] { rockSlide, ironTail });

                Pokemon alakazam = new Pokemon("Alakazam",
                                new TiposEnum[] { TiposEnum.PSYCHIC },
                                new TiposEnum[] { TiposEnum.BUG, TiposEnum.GHOST, TiposEnum.DARK },
                                120, 45, 55, 30,
                                new Tecnicas[] { psychic, shadowBall });

                Pokemon machamp = new Pokemon("Machamp",
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] { TiposEnum.FLYING, TiposEnum.PSYCHIC, TiposEnum.FAIRY },
                                100, 85, 90, 36,
                                new Tecnicas[] { brickBreak, dynamicPunch });

                Pokemon gyarados = new Pokemon("Gyarados",
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.FLYING },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.ROCK },
                                125, 79, 95, 27,
                                new Tecnicas[] { surf, dragonClaw });

                Pokemon dragonite = new Pokemon("Dragonite",
                                new TiposEnum[] { TiposEnum.DRAGON, TiposEnum.FLYING },
                                new TiposEnum[] { TiposEnum.ICE, TiposEnum.DRAGON, TiposEnum.FAIRY },
                                134, 95, 91, 45,
                                new Tecnicas[] { dragonClaw, hyperBeam });

                Pokemon meowth = new Pokemon("Meowth",
                                new TiposEnum[] { TiposEnum.NORMAL },
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                45, 35, 40, 39,
                                new Tecnicas[] { slash, ironTail });

                Pokemon psyduck = new Pokemon("Psyduck",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                52, 48, 50, 28,
                                new Tecnicas[] { surf, psychic });

                Pokemon machop = new Pokemon("Machop",
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] { TiposEnum.FLYING, TiposEnum.PSYCHIC, TiposEnum.FAIRY },
                                70, 50, 70, 30,
                                new Tecnicas[] { brickBreak, rockSlide });

                Pokemon poliwag = new Pokemon("Poliwag",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                50, 40, 40, 30,
                                new Tecnicas[] { surf, iceBeam });

                Pokemon growlithe = new Pokemon("Growlithe",
                                new TiposEnum[] { TiposEnum.FIRE },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.GROUND },
                                70, 45, 55, 40,
                                new Tecnicas[] { flamethrower, quickAttack });

                Pokemon seel = new Pokemon("Seel",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                65, 55, 65, 23,
                                new Tecnicas[] { surf, iceBeam });

                Pokemon omanyte = new Pokemon("Omanyte",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.ELECTRIC }, 40, 100, 70, 13,
                                new Tecnicas[] { surf, rockSlide });

                Pokemon kabuto = new Pokemon("Kabuto",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.BUG },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.FIGHTING }, 40, 80, 60,
                                18,
                                new Tecnicas[] { slash, ironTail });

        }

}
