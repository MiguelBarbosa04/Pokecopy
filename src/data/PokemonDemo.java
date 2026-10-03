package data;

import enums.TiposEnum;
import models.Pokemon;
import models.Tecnicas;

public class PokemonDemo {
        public void criarPokemons() {

                Tecnicas flamethrower = new Tecnicas("flamethrower", 90, 100, new TiposEnum[] { TiposEnum.FIRE });
                Tecnicas thunderbolt = new Tecnicas("thunderbolt", 90, 100, new TiposEnum[] { TiposEnum.ELECTRIC });
                Tecnicas surf = new Tecnicas("surf", 90, 100, new TiposEnum[] { TiposEnum.WATER });
                Tecnicas psychic = new Tecnicas("psychic", 90, 100, new TiposEnum[] { TiposEnum.PSYCHIC });
                Tecnicas earthquake = new Tecnicas("earthquake", 100, 100, new TiposEnum[] { TiposEnum.GROUND });
                Tecnicas iceBeam = new Tecnicas("iceBeam", 90, 100, new TiposEnum[] { TiposEnum.ICE });
                Tecnicas sludgeBomb = new Tecnicas("sludgeBomb", 90, 100, new TiposEnum[] { TiposEnum.POISON });
                Tecnicas hyperBeam = new Tecnicas("hyperBeam", 150, 90, new TiposEnum[] { TiposEnum.NORMAL });
                Tecnicas rockSlide = new Tecnicas("rockSlide", 75, 90, new TiposEnum[] { TiposEnum.ROCK });
                Tecnicas shadowBall = new Tecnicas("shadowBall", 80, 100, new TiposEnum[] { TiposEnum.GHOST });
                Tecnicas dragonClaw = new Tecnicas("dragonClaw", 80, 100, new TiposEnum[] { TiposEnum.DRAGON });
                Tecnicas darkPulse = new Tecnicas("darkPulse", 80, 100, new TiposEnum[] { TiposEnum.DARK });
                Tecnicas dazzlingGleam = new Tecnicas("dazzlingGleam", 80, 100, new TiposEnum[] { TiposEnum.FAIRY });
                Tecnicas aerialAce = new Tecnicas("aerialAce", 60, 100, new TiposEnum[] { TiposEnum.FLYING });
                Tecnicas brickBreak = new Tecnicas("brickBreak", 75, 100, new TiposEnum[] { TiposEnum.FIGHTING });
                Tecnicas bugBuzz = new Tecnicas("bugBuzz", 90, 100, new TiposEnum[] { TiposEnum.BUG });
                Tecnicas ironTail = new Tecnicas("ironTail", 100, 75, new TiposEnum[] { TiposEnum.STEEL });
                Tecnicas quickAttack = new Tecnicas("quickAttack", 70, 100, new TiposEnum[] { TiposEnum.NORMAL });
                Tecnicas dynamicPunch = new Tecnicas("dynamicPunch", 100, 50, new TiposEnum[] { TiposEnum.FIGHTING });
                Tecnicas slash = new Tecnicas("slash", 70, 100, new TiposEnum[] { TiposEnum.NORMAL });

                // Ordem dos argumentos:
                // nome, tipos, fraquezas, resistencias, imunidades, ataque, defesa, vida, velocidade, tecnicas

                Pokemon bulbasaur = new Pokemon("Bulbasaur",
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.POISON },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.ICE, TiposEnum.FLYING, TiposEnum.PSYCHIC },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ELECTRIC, TiposEnum.GRASS,
                                                TiposEnum.FIGHTING, TiposEnum.FAIRY },
                                new TiposEnum[] {},
                                55, 40, 250, 20,
                                new Tecnicas[] { sludgeBomb, earthquake });

                Pokemon charmander = new Pokemon("Charmander",
                                new TiposEnum[] { TiposEnum.FIRE },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.BUG,
                                                TiposEnum.STEEL, TiposEnum.FAIRY },
                                new TiposEnum[] {},
                                60, 35, 290, 30,
                                new Tecnicas[] { flamethrower, dragonClaw });

                Pokemon squirtle = new Pokemon("Squirtle",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.WATER, TiposEnum.ICE, TiposEnum.STEEL },
                                new TiposEnum[] {},
                                50, 65, 240, 24,
                                new Tecnicas[] { surf, iceBeam });

                Pokemon pikachu = new Pokemon("Pikachu",
                                new TiposEnum[] { TiposEnum.ELECTRIC },
                                new TiposEnum[] { TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.FLYING, TiposEnum.STEEL },
                                new TiposEnum[] {},
                                55, 40, 250, 50,
                                new Tecnicas[] { thunderbolt, quickAttack });

                Pokemon jigglypuff = new Pokemon("Jigglypuff",
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FAIRY },
                                new TiposEnum[] { TiposEnum.POISON, TiposEnum.STEEL },
                                new TiposEnum[] { TiposEnum.BUG, TiposEnum.DARK },
                                new TiposEnum[] { TiposEnum.GHOST, TiposEnum.DRAGON },
                                45, 20, 315, 32,
                                new Tecnicas[] { hyperBeam, dazzlingGleam });

                Pokemon geodude = new Pokemon("Geodude",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND, TiposEnum.STEEL },
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FIRE, TiposEnum.POISON,
                                                TiposEnum.FLYING, TiposEnum.ROCK },
                                new TiposEnum[] { TiposEnum.ELECTRIC },
                                80, 100, 200, 19,
                                new Tecnicas[] { rockSlide, earthquake });

                Pokemon gastly = new Pokemon("Gastly",
                                new TiposEnum[] { TiposEnum.GHOST, TiposEnum.POISON },
                                new TiposEnum[] { TiposEnum.GROUND, TiposEnum.PSYCHIC, TiposEnum.GHOST,
                                                TiposEnum.DARK },
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.POISON, TiposEnum.BUG, TiposEnum.FAIRY },
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FIGHTING },
                                35, 30, 200, 31,
                                new Tecnicas[] { shadowBall, sludgeBomb });

                Pokemon onix = new Pokemon("Onix",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND, TiposEnum.STEEL },
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FIRE, TiposEnum.POISON,
                                                TiposEnum.FLYING, TiposEnum.ROCK },
                                new TiposEnum[] { TiposEnum.ELECTRIC },
                                45, 160, 250, 20,
                                new Tecnicas[] { rockSlide, ironTail });

                Pokemon alakazam = new Pokemon("Alakazam",
                                new TiposEnum[] { TiposEnum.PSYCHIC },
                                new TiposEnum[] { TiposEnum.BUG, TiposEnum.GHOST, TiposEnum.DARK },
                                new TiposEnum[] { TiposEnum.FIGHTING, TiposEnum.PSYCHIC },
                                new TiposEnum[] {},
                                120, 45, 350, 30,
                                new Tecnicas[] { psychic, shadowBall });

                Pokemon machamp = new Pokemon("Machamp",
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] { TiposEnum.FLYING, TiposEnum.PSYCHIC, TiposEnum.FAIRY },
                                new TiposEnum[] { TiposEnum.BUG, TiposEnum.ROCK, TiposEnum.DARK },
                                new TiposEnum[] {},
                                100, 85, 350, 36,
                                new Tecnicas[] { brickBreak, dynamicPunch });

                Pokemon gyarados = new Pokemon("Gyarados",
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.FLYING },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.ROCK },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.WATER, TiposEnum.STEEL,
                                                TiposEnum.FIGHTING, TiposEnum.BUG },
                                new TiposEnum[] { TiposEnum.GROUND },
                                125, 79, 350, 27,
                                new Tecnicas[] { surf, dragonClaw });

                Pokemon dragonite = new Pokemon("Dragonite",
                                new TiposEnum[] { TiposEnum.DRAGON, TiposEnum.FLYING },
                                new TiposEnum[] { TiposEnum.ICE, TiposEnum.DRAGON, TiposEnum.FAIRY, TiposEnum.ROCK },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.WATER, TiposEnum.GRASS,
                                                TiposEnum.FIGHTING, TiposEnum.BUG },
                                new TiposEnum[] { TiposEnum.GROUND },
                                134, 95, 370, 45,
                                new Tecnicas[] { dragonClaw, hyperBeam });

                Pokemon meowth = new Pokemon("Meowth",
                                new TiposEnum[] { TiposEnum.NORMAL },
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] {},
                                new TiposEnum[] { TiposEnum.GHOST },
                                45, 35, 300, 39,
                                new Tecnicas[] { slash, ironTail });

                Pokemon psyduck = new Pokemon("Psyduck",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.WATER, TiposEnum.ICE, TiposEnum.STEEL },
                                new TiposEnum[] {},
                                52, 48, 200, 28,
                                new Tecnicas[] { surf, psychic });

                Pokemon machop = new Pokemon("Machop",
                                new TiposEnum[] { TiposEnum.FIGHTING },
                                new TiposEnum[] { TiposEnum.FLYING, TiposEnum.PSYCHIC, TiposEnum.FAIRY },
                                new TiposEnum[] { TiposEnum.BUG, TiposEnum.ROCK, TiposEnum.DARK },
                                new TiposEnum[] {},
                                70, 50, 200, 30,
                                new Tecnicas[] { brickBreak, rockSlide });

                Pokemon poliwag = new Pokemon("Poliwag",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.WATER, TiposEnum.ICE, TiposEnum.STEEL },
                                new TiposEnum[] {},
                                50, 40, 300, 30,
                                new Tecnicas[] { surf, iceBeam });

                Pokemon growlithe = new Pokemon("Growlithe",
                                new TiposEnum[] { TiposEnum.FIRE },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.GRASS, TiposEnum.ICE, TiposEnum.BUG,
                                                TiposEnum.STEEL, TiposEnum.FAIRY },
                                new TiposEnum[] {},
                                70, 45, 250, 40,
                                new Tecnicas[] { flamethrower, quickAttack });

                Pokemon seel = new Pokemon("Seel",
                                new TiposEnum[] { TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.ELECTRIC, TiposEnum.GRASS },
                                new TiposEnum[] { TiposEnum.FIRE, TiposEnum.WATER, TiposEnum.ICE, TiposEnum.STEEL },
                                new TiposEnum[] {},
                                65, 55, 250, 23,
                                new Tecnicas[] { surf, iceBeam });

                Pokemon omanyte = new Pokemon("Omanyte",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.WATER },
                                new TiposEnum[] { TiposEnum.GRASS, TiposEnum.ELECTRIC, TiposEnum.FIGHTING,
                                                TiposEnum.GROUND },
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.FIRE, TiposEnum.POISON,
                                                TiposEnum.FLYING, TiposEnum.ICE },
                                new TiposEnum[] {},
                                40, 100, 300, 13,
                                new Tecnicas[] { surf, rockSlide });

                Pokemon kabuto = new Pokemon("Kabuto",
                                new TiposEnum[] { TiposEnum.ROCK, TiposEnum.BUG },
                                new TiposEnum[] { TiposEnum.WATER, TiposEnum.ROCK, TiposEnum.STEEL },
                                new TiposEnum[] { TiposEnum.NORMAL, TiposEnum.POISON },
                                new TiposEnum[] {},
                                40, 80, 300, 18,
                                new Tecnicas[] { slash, ironTail });

        }

}