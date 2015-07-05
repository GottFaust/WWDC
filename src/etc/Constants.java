package etc;

public class Constants {
  
  /** Mod Type Constants **/
  public static final String MOD_TYPE_DAMAGE_BONUS = "DamageBonus";
  public static final String MOD_TYPE_FIRE_DAMAGE = "FireDamage";
  public static final String MOD_TYPE_LIGHTNING_DAMAGE = "LightningDamage";
  public static final String MOD_TYPE_ICE_DAMAGE = "IceDamage";
  public static final String MOD_TYPE_PUNCTURE_DAMAGE = "PunctureDamage";
  public static final String MOD_TYPE_TOXIN_DAMAGE = "ToxinDamage";
  public static final String MOD_TYPE_IMPACT_DAMAGE = "ImpactDamage";
  public static final String MOD_TYPE_SLASH_DAMAGE = "SlashDamage";
  public static final String MOD_TYPE_MISC_DAMAGE = "MiscDamage";
  public static final String MOD_TYPE_MULTISHOT = "Multishot";
  public static final String MOD_TYPE_FIRE_RATE = "FireRate";
  public static final String MOD_TYPE_RELOAD_SPEED = "ReladSpeed";
  public static final String MOD_TYPE_MAG_CAP = "MagCap";
  public static final String MOD_TYPE_AMMO_CAP = "AmmoCap";
  public static final String MOD_TYPE_CORPUS_DAMAGE = "CorpusDamage";
  public static final String MOD_TYPE_GRINEER_DAMAGE = "GrineerDamage";
  public static final String MOD_TYPE_INFESTED_DAMAGE = "InfestedDamage";
  public static final String MOD_TYPE_CRIT_CHANCE = "CritChance";
  public static final String MOD_TYPE_CRIT_MULTIPLIER = "CritMultiplier";
  public static final String MOD_TYPE_STATUS_CHANCE = "StatusChance";
  public static final String MOD_TYPE_STATUS_DURATION = "StatusDuration";
  public static final String MOD_TYPE_FIRST_SHOT_DAMAGE = "FirstShotDamage";
  public static final String MOD_TYPE_ZOOM = "Zoom";
  public static final String MOD_TYPE_OBJECT_PIERCE = "ObjectPierce";
  public static final String MOD_TYPE_AMMO_MUTATOR = "AmmoMutator";
  public static final String MOD_TYPE_ACCURACY = "AccuracyBonus";
  public static final String MOD_TYPE_RECOIL = "RecoilBonus";
  public static final String MOD_TYPE_SPREAD = "SpreadBonus";
  public static final String MOD_TYPE_SILENCE = "Silence";
  public static final String MOD_TYPE_FLAT_DAMAGE = "FlatDamageBonus";
  public static final String MOD_TYPE_DEAD_AIM = "DeadAim";
  public static final String MOD_TYPE_FLAT_STATUS = "FlatStatusBonus";
  public static final String MOD_TYPE_FLAT_MAG = "FlatMagBonus";
  
  /** Damage Types **/
  public static final String PHYSICAL_WEAPON_DAMAGE = "Physical";
  public static final String IMPACT_WEAPON_DAMAGE = "Impact";
  public static final String PUNCTURE_WEAPON_DAMAGE = "Puncture";
  public static final String SLASH_WEAPON_DAMAGE = "Slash";
  public static final String FIRE_WEAPON_DAMAGE = "Fire";
  public static final String ICE_WEAPON_DAMAGE = "Ice";
  public static final String ELECTRIC_WEAPON_DAMAGE = "Electric";
  public static final String TOXIN_WEAPON_DAMAGE = "Toxin";
  public static final String BLAST_WEAPON_DAMAGE = "Blast";
  public static final String MAGNETIC_WEAPON_DAMAGE = "Magnetic";
  public static final String GAS_WEAPON_DAMAGE = "Gas";
  public static final String RADIATION_WEAPON_DAMAGE = "Radiation";
  public static final String CORROSIVE_WEAPON_DAMAGE = "Corrosive";
  public static final String VIRAL_WEAPON_DAMAGE = "Viral";
  
  public static final String NO_WEAPON_DAMAGE = "None";
  
  /** Weapon Modes **/
  public static final String BURST = "Burst";
  public static final String CHARGE = "Charge";
  public static final String CONTINUOUS = "Continuous";
  public static final String FULL_AUTO = "Full-Auto";
  public static final String FULL_AUTO_RAMP_UP = "Full-Auto (Ramp-up)";
  public static final String FULL_AUTO_BULLET_RAMP = "Full-Auto (Bullet-Ramp)";
  public static final String SEMI_AUTO = "Semi-Auto";
  
  /** Frame Title **/
  public static final String APP_TITLE = "Warframe Weapon DPS Calculator";
  public static final String APP_VERSION = "v0.7.6";
  
  /** ToolTips **/
  public static final String NAME_TOOL_TIP = "The weapon's name.";
  public static final String DAMAGE_TOOL_TIP = "The weapon's base damage.";
  public static final String IMPACT_TOOL_TIP = "The weapon's impact damage.";
  public static final String PUNCTURE_TOOL_TIP = "The weapon's puncture damage.";
  public static final String SLASH_TOOL_TIP = "The weapon's slash damage.";
  public static final String POJECTILE_TOOL_TIP = "The number of projectiles fired per shot";
  public static final String CONTINUOUS_DAMAGE_TOOL_TIP = "The base damage displayed by the weapon.";
  public static final String FIRE_RATE_TOOL_TIP = "The weapon's fire rate in bullets per seconds.";
  public static final String MAG_SIZE_TOOL_TIP = "<HTML>The weapon's magazine size. <br>Depending on the weapon, this can also be referred to as clip size.<HTML>";
  public static final String TOTAL_AMMO_TOOL_TIP = "The weapons's total available ammo not including the first mag.";
  public static final String RELOAD_TIME_TOOL_TIP = "The weapon's reload time in seconds";
  public static final String CRIT_CHANCE_TOOL_TIP = "<HTML>The weapon's critical chance in whole number percents. <br>For example, the Lanka has a 20 base crit chance.</HTML>";
  public static final String CRIT_MULT_TOOL_TIP = "<HTML>The Weapon's critical damage multiplier in decimal format. <br>For example, the Lanka has a 1.5 base crit multiplier.</HTML>";
  public static final String WEAPON_MODE_TOOL_TIP = "The weapon's mode of operation.";
  public static final String DAMAGE_TYPE_TOOL_TIP = "<HTML>The type of base damage that this weapon does. <br>This info can be obtained most easily from the warframe wiki.</HTML>";
  public static final String CHARGE_TIME_TOOL_TIP = "The time it takes the weapon to charge before being able to fire.";
  public static final String BURST_COUNT_TOOL_TIP = "The number of bullets fired in each burst.";
  public static final String BURST_FIRE_RATE_TOOL_TIP = "The rate of fire during each burst iteration";
  public static final String STATUS_TOOL_TIP = "The base status chance of this weapon.";
  
  /** Weapon Types **/
  public static final String SHOTGUN = "Shotgun";
  public static final String RIFLE = "Rifle";
  public static final String PISTOL = "Pistol";
  public static final String ARCGUN = "ArcGun";
  
  /** Mod Effect Count **/
  public static final String SINGLE = "Single";
  public static final String DOUBLE = "Double";
  
  /** Mod Polarities **/
  public static final String NONE = "None";
  public static final String DASH = "~";
  public static final String EQUALS = "=";
  public static final String D = "D";
  public static final String V = "V";
  
  /** UI Text Values **/
  public static final String MOD_LABEL = "Mod:";
  public static final String RANK_LABEL = "Rank:";
  public static final String SLOT_POLARITY_LABEL = ":Pol:";
  public static final String MOD_POLARITY_LABEL = "Mod-Pol:";
  public static final String COST_LABEL = ":Cost:";
  public static final String CUSTOM_WEAPON = "Custom";
  
  /** Enemy Values **/
  public static final String ENEMY_TYPE_INFESTED = "Infested";
  public static final String ENEMY_TYPE_CORPUS = "Corpus";
  public static final String ENEMY_TYPE_GRINEER = "Grineer";
  public static final String ENEMY_SURFACE_CLONE_FLESH = "CloneFlesh";
  public static final String ENEMY_SURFACE_FERRITE_ARMOR = "FerriteArmor";
  public static final String ENEMY_SURFACE_ALLOY_ARMOR = "AlloyArmor";
  public static final String ENEMY_SURFACE_MECHANICAL = "Mechanical";
  public static final String ENEMY_SURFACE_CORPUS_FLESH = "CorpusFlesh";
  public static final String ENEMY_SURFACE_PROTO_SHIELD = "ProtoShield";
  public static final String ENEMY_SURFACE_INFESTED_FLESH = "InfestedFlesh";
  public static final String ENEMY_SURFACE_FOSSILIZED = "Fossilized";
  public static final String ENEMY_SURFACE_SINEW = "Sinew";
  public static final String ENEMY_SURFACE_SHIELDS = "Shields";
  public static final String ENEMY_SURFACE_ROBOTIC = "Robotic";
  public static final String ENEMY_SURFACE_INFESTED = "Infested";
  
  /** Color Names **/
  public static final String CONTAINER_BACKGROUND_COLOR_NAME = "Container Background";
  public static final String TEXT_AREA_BACKGROUND_COLOR_NAME = "Text Field Background";
  public static final String BUTTON_BACKGROUND_COLOR_NAME = "Button Background";
  public static final String GRAPH_DEMARCATION_COLOR_NAME = "Graph Line";
  public static final String TEXT_FOREGROUND_COLOR_NAME = "Text";
  public static final String BUTTON_FOREGROUND_COLOR_NAME = "Button Text";
  public static final String LABEL_FOREGROUND_COLOR_NAME = "Label Text";
  public static final String BORDER_COLOR_NAME = "Borders";
  public static final String LIGHER_BORDER_COLOR_NAME = "Mod Borders";
  public static final String CURRENT_GRAPH_COLOR_NAME = "Current DPS Graph";
  public static final String PREVIOUS_GRAPH_COLOR_NAME = "Previous DPS Graph";
  
  /** Default Color options for use if the file is missing **/
  public static final String[] baseColorOptions = { CONTAINER_BACKGROUND_COLOR_NAME+";44,44,44",
                                                    TEXT_AREA_BACKGROUND_COLOR_NAME+";0,0,0",
                                                    BUTTON_BACKGROUND_COLOR_NAME+";0,0,0",
                                                    GRAPH_DEMARCATION_COLOR_NAME+";124,124,124",
                                                    TEXT_FOREGROUND_COLOR_NAME+";0,255,0",
                                                    BUTTON_FOREGROUND_COLOR_NAME+";0,255,0",
                                                    LABEL_FOREGROUND_COLOR_NAME+";0,204,0",
                                                    BORDER_COLOR_NAME+";255,255,0",
                                                    LIGHER_BORDER_COLOR_NAME+";0,255,0",
                                                    CURRENT_GRAPH_COLOR_NAME+";255,255,0",
                                                    PREVIOUS_GRAPH_COLOR_NAME+";124,124,124"};
  
  /** Default TTK Targets for use if the file is missing**/
  public static final String[] baseTTKTargets = { "Corpus Tech,15,95,0,700,250,CorpusFlesh,FerriteArmor,ProtoShield,Corpus,0",
                                                  "Toxic Ancient,1,95,0,400,0,Fossilized,FerriteArmor,Shields,Infested,0",
                                                  "Heavy Gunner,8,95,500,300,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,0",
                                                  "Fusion Moa,15,95,0,250,250,Robotic,FerriteArmor,Shields,Corpus,0",
                                                  "Corrupted Butcher,1,95,5,100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Lancer,1,95,200,60,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Crewman,1,95,0,60,150,CorpusFlesh,AlloyArmor,Shields,Grineer,4",
                                                  "Corrupted Nullifier,1,95,0,60,150,CorpusFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted MOA,1,95,0,250,250,Robotic,AlloyArmor,Shields,Grineer,4",
                                                  "Corrupted Ancient,1,95,0,400,0,Fossilized,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Heavy Gunner,8,95,500,700,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Bombard,4,95,500,300,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Heavy Gunner Leech Eximus,8,95,800,2100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,4",
                                                  "Corrupted Bombard Leech Eximus,4,95,800,900,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,4",
                                                  "Butcher,1,95,5,50,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Scorpion,10,95,150,150,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Elite Lancer,15,95,200,150,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Trooper,1,95,150,120,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Ballista,1,95,100,100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Scorch,10,95,100,120,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Seeker,1,95,200,100,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Drahk Master,12,95,200,500,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Drahk,1,95,175,300,0,CorpusFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Napalm,6,95,500,600,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Heavy Gunner,8,95,500,300,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Bombard,1,95,500,300,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Napalm Leech Eximus,6,95,800,1800,0,CloneFlesh,AlloyArmor,ProtoShield,Grineer,1",
                                                  "Heavy Gunner Leech Eximus,8,95,800,900,0,CloneFlesh,FerriteArmor,ProtoShield,Grineer,1",
                                                  "Prod Crewman,1,95,0,100,50,CorpusFlesh,AlloyArmor,Shields,Corpus,2",
                                                  "Crewman,1,95,0,60,150,CorpusFlesh,AlloyArmor,Shields,Corpus,2",
                                                  "Sniper Crewman,15,95,0,60,150,CorpusFlesh,AlloyArmor,ProtoShield,Corpus,2",
                                                  "Elite Crewman,15,95,0,100,200,CorpusFlesh,AlloyArmor,Shields,Corpus,2",
                                                  "Tech,15,95,0,700,250,CorpusFlesh,AlloyArmor,ProtoShield,Corpus,2",
                                                  "Nullifer Crewman,1,95,0,600,150,CorpusFlesh,AlloyArmor,ProtoShield,Corpus,2",
                                                  "MOA,1,95,0,60,150,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Fusion MOA,15,95,0,250,250,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Fusion MOA Drone,15,95,0,250,75,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Anti MOA,5,95,0,50,500,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Oxium Osprey,1,95,0,750,150,Robotic,AlloyArmor,Shields,Corpus,2",
                                                  "Bursa,1,95,350,2500,2400,Robotic,FerriteArmor,Shields,Corpus,2",
                                                  "Charger,1,95,0,80,0,Infested,AlloyArmor,ProtoShield,Infested,3",
                                                  "Volatile Runner,1,95,0,80,0,InfestedFlesh,AlloyArmor,ProtoShield,Infested,3",
                                                  "Runner,1,95,0,100,0,Infested,AlloyArmor,ProtoShield,Infested,3",
                                                  "Crawler,1,95,0,50,0,InfestedFlesh,AlloyArmor,ProtoShield,Infested,3",
                                                  "Ancient,1,95,0,400,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Mutalist Osprey,1,95,0,200,0,InfestedFlesh,AlloyArmor,ProtoShield,Infested,3",
                                                  "Mutalist MOA,0,95,0,350,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Brood Mother,1,95,0,700,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Boiler,1,95,0,1200,0,Fossilized,AlloyArmor,ProtoShield,Infested,3",
                                                  "Juggernaut,1,95,200,3500,0,Infested,FerriteArmor,ProtoShield,Infested,3"};
  
  /** The Default Mod DB for use if the file is missing **/
  public static final String[] baseModDB = {"Accelerated Blast,Shotgun,3,2,FireRate,PunctureDamage,0.15,0.15,V,6",
                                            "Ammo Drum,Rifle,5,1,AmmoCap,0.05,~,2",
                                            "Ammo Stock,Shotgun,5,1,MagCap,0.1,~,2",
                                            "Anemic Agility,Pistol,5,2,FireRate,DamageBonus,0.15,-0.025,~,4",
                                            "Arrow Mutation,Rifle,3,1,AmmoMutator,0.0,~,4",
                                            "Bane of Corpus,Rifle,5,1,CorpusDamage,0.05,V,4",
                                            "Bane of Grineer,Rifle,5,1,GrineerDamage,0.05,V,4",
                                            "Bane of Infested,Rifle,5,1,InfestedDamage,0.05,V,4",
                                            "Barrel Diffusion,Pistol,5,1,Multishot,0.2,V,6",
                                            "Blaze,Shotgun,3,2,DamageBonus,FireDamage,0.15,0.15,V,6",
                                            "Blunderbuss,Shotgun,5,1,CritChance,0.15,V,4",
                                            "Bore,Pistol,5,1,PunctureDamage,0.2,~,6",
                                            "Breach Loader,Shotgun,5,1,PunctureDamage,0.2,~,6",
                                            "Burdened Magazine,Shotgun,5,2,MagCap,ReladSpeed,0.1,-0.03,~,6",
                                            "Charged Chamber,Rifle,3,1,FirstShotDamage,0.1,V,6",
                                            "Charged Shell,Shotgun,5,1,LightningDamage,0.15,~,6",
                                            "Chilling Grasp,Shotgun,5,1,IceDamage,0.15,D,6",
                                            "Cleanse Corpus,Shotgun,5,1,CorpusDamage,0.05,V,4",
                                            "Cleanse Grineer,Shotgun,5,1,GrineerDamage,0.05,V,4",
                                            "Cleanse Infested,Shotgun,5,1,InfestedDamage,0.05,V,4",
                                            "Concussion Rounds,Pistol,5,1,ImpactDamage,0.1,~,2",
                                            "Contagious Spread,Shotgun,5,1,ToxinDamage,0.15,~,6",
                                            "Continuous Misery,Rifle,3,1,StatusDuration,0.25,V,4",
                                            "Convulsion,Pistol,5,1,LightningDamage,0.15,~,6",
                                            "Crash Course,Rifle,5,1,ImpactDamage,0.2,~,6",
                                            "Creeping Bullseye,Pistol,5,2,CritChance,FireRate,0.08,-0.06,~,4",
                                            "Critical Deceleration,Shotgun,5,2,CritChance,FireRate,0.08,-0.05,V,4",
                                            "Critical Delay,Rifle,5,2,CritChance,FireRate,0.08,-0.06,~,4",
                                            "Cryo Rounds,Rifle,5,1,IceDamage,0.15,D,6",
                                            "Deadly Sequence,Rifle,3,1,CritChance,0.5,V,4",
                                            "Deep Freeze,Pistol,5,1,IceDamage,0.15,D,6",
                                            "Disruptor,Shotgun,5,1,ImpactDamage,0.05,~,4",
                                            "Eagle Eye,Rifle,3,1,Zoom,0.0,~,4",
                                            "Entropy Burst,Rifle,3,1,FlatStatusBonus,0.05,V,4",
                                            "Erroding Blight,Pistol,3,1,MagCap,0.5,D,4",
                                            "Expel Corpus,Pistol,5,1,CorpusDamage,0.05,V,4",
                                            "Expel Grineer,Pistol,5,1,GrineerDamage,0.05,V,4",
                                            "Expel Infested,Pistol,5,1,InfestedDamage,0.05,V,4",
                                            "Fanged Fusillade,Rifle,5,1,SlashDamage,0.2,~,6",
                                            "Fast Hands,Rifle,5,1,ReladSpeed,0.05,~,2",
                                            "Firestorm,Rifle,3,1,MiscDamage,0.0,V,6",
                                            "Flechette,Shotgun,5,1,PunctureDamage,0.05,~,4",
                                            "Frail Momentum,Shotgun,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
                                            "Fridgid Blast,Shotgun,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
                                            "Frostbite,Pistol,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
                                            "Full Contact,Shotgun,5,1,ImpactDamage,0.2,~,6",
                                            "Gilded Truth,Rifle,3,1,FireRate,0.2,V,4",
                                            "Gunslinger,Pistol,5,1,FireRate,0.12,V,4",
                                            "Hammer Shot,Rifle,3,2,StatusChance,CritMultiplier,0.1,0.15,D,6",
                                            "Hawk Eye,Pistol,3,1,Zoom,0.0,~,4",
                                            "Heated Charge,Pistol,5,1,FireDamage,0.15,~,6",
                                            "Heavy Caliber,Rifle,10,2,DamageBonus,AccuracyBonus,0.15,-0.05,V,6",
                                            "Hell's Chamber,Shotgun,5,1,Multishot,0.2,V,10",
                                            "Hellfire,Rifle,5,1,FireDamage,0.15,~,6",
                                            "High Voltage,Rifle,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
                                            "Hollow Point,Pistol,5,2,CritMultiplier,DamageBonus,0.1,-0.025,~,4",
                                            "Hornet Strike,Pistol,10,1,DamageBonus,0.2,V,4",
                                            "Hush,Rifle,3,1,Silence,0.25,~,2",
                                            "Ice Storm,Pistol,3,2,MagCap,IceDamage,0.1,0.1,V,6",
                                            "Incendiary Coat,Shotgun,5,1,FireDamage,0.15,~,6",
                                            "Infected Clip,Rifle,5,1,ToxinDamage,0.15,~,6",
                                            "Jolt,Pistol,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
                                            "Lasting Purity,Rifle,3,1,DeadAim,0.15,~,4",
                                            "Lethal Torrent,Pistol,5,2,FireRate,Multishot,0.1,0.1,V,6",
                                            "Lingering Torment,Shotgun,5,1,StatusDuration,0.05,V,6",
                                            "Magazine Warp,Rifle,5,1,MagCap,0.05,~,4",
                                            "Magnum Force,Pistol,10,2,DamageBonus,AccuracyBonus,0.06,-0.03,V,4",
                                            "Maim,Pistol,5,1,SlashDamage,0.2,~,6",
                                            "Malignant Force,Rifle,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
                                            "Metal Auger,Rifle,5,1,ObjectPierce,0.0,~,10",
                                            "No Return,Pistol,5,1,PunctureDamage,0.1,~,2",
                                            "Pathogen Rounds,Pistol,5,1,ToxinDamage,0.15,~,6",
                                            "Perpetual Agony,Pistol,5,1,StatusDuration,0.05,V,6",
                                            "Piercing Caliber,Rifle,5,1,PunctureDamage,0.2,~,6",
                                            "Piercing Hit,Rifle,5,1,PunctureDamage,0.05,~,4",
                                            "Pistol Gambit,Pistol,5,1,CritChance,0.2,V,4",
                                            "Pistol Mutation,Pistol,3,1,AmmoMutator,0.0,~,4",
                                            "Pistol Pestilence,Pistol,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
                                            "Point Blank,Shotgun,5,1,DamageBonus,0.15,V,4",
                                            "Point Strike,Rifle,5,1,CritChance,0.25,V,4",
                                            "Primed Chamber,Rifle,3,1,FirstShotDamage,0.25,V,4",
                                            "Primed Fast Hands,Rifle,10,1,ReladSpeed,0.05,~,2",
                                            "Primed Heated Charge,Pistol,10,1,FireDamage,0.15,~,6",
                                            "Primed Pistol Gambit,Pistol,10,1,CritChance,0.17,V,2",
                                            "Primed Point Blank,Shotgun,10,1,DamageBonus,0.15,V,4",
                                            "Primed Ravage,Shotgun,10,1,CritMultiplier,0.1,V,4",
                                            "Quickdraw,Pistol,5,1,ReladSpeed,0.08,~,2",
                                            "Ravage,Shotgun,5,1,CritMultiplier,0.1,V,4",
                                            "Razor Shot,Pistol,5,1,SlashDamage,0.1,~,2",
                                            "Rifle Aptitude,Rifle,5,1,StatusChance,0.025,D,4",
                                            "Rifle Mutation,Rifle,3,1,AmmoMutator,0.0,~,4",
                                            "Rime Rounds,Rifle,3,2,IceDamage,StatusChance,0.15,0.15,V,4",
                                            "Rupture,Rifle,5,1,ImpactDamage,0.05,~,4",
                                            "Sawtooth Clip,Rifle,5,1,SlashDamage,0.05,~,4",
                                            "Scattered Justice,Shotgun,3,1,Multishot,0.5,V,4",
                                            "Scattering Inferno,Shotgun,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Scorch,Pistol,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Seeker,Pistol,5,1,ObjectPierce,0.0,~,10",
                                            "Seeking Force,Shotgun,5,1,ObjectPierce,0.0,~,10",
                                            "Serration,Rifle,10,1,DamageBonus,0.15,V,4",
                                            "Shattering Justice,Shotgun,3,1,FlatStatusBonus,0.05,~,4",
                                            "Shell Compression,Shotgun,5,1,AmmoCap,0.05,~,2",
                                            "Shell Shock,Shotgun,3,2,LightningDamage,StatusChance,0.15,0.15,V,4",
                                            "Shotgun Mutation,Shotgun,3,1,AmmoMutator,0.0,~,4",
                                            "Shotgun Savvy,Shotgun,5,1,StatusChance,0.05,D,4",
                                            "Shotgun Spazz,Shotgun,5,1,FireRate,0.15,V,4",
                                            "Shred,Rifle,5,2,FireRate,ObjectPierce,0.05,0.0,V,6",
                                            "Shredder,Shotgun,5,1,SlashDamage,0.05,~,4",
                                            "Slip Magazine,Pistol,5,1,MagCap,0.05,~,4",
                                            "Sniper Mutation,Rifle,3,1,AmmoMutator,0.0,~,4",
                                            "Speed Trigger,Rifle,5,1,FireRate,0.1,V,4",
                                            "Split Chamber,Rifle,5,1,Multishot,0.15,V,10",
                                            "Stabilizer,Rifle,3,1,RecoilBonus,-0.15,~,6",
                                            "Steady hands,Pistol,3,1,RecoilBonus,-0.15,~,6",
                                            "Stinging Truth,Pistol,3,1,FlatMagBonus,0.1,D,4",
                                            "Stormbringer,Rifle,5,1,LightningDamage,0.15,~,6",
                                            "Stunning Speed,Pistol,3,2,StatusChance,ReladSpeed,0.025,0.1,~,6",
                                            "Suppress,Pistol,3,1,Silence,0.25,~,2",
                                            "Sure Shot,Pistol,5,1,StatusChance,0.025,D,2",
                                            "Sweeping Serration,Shotgun,5,1,SlashDamage,0.2,~,6",
                                            "Tactical Pump,Shotgun,5,1,ReladSpeed,0.05,~,2",
                                            "Tainted Clip,Pistol,5,2,MagCap,ReladSpeed,0.1,-0.05,~,6",
                                            "Tainted Mag,Rifle,10,2,MagCap,ReladSpeed,0.06,-0.03,~,4",
                                            "Tainted Shell,Shotgun,10,2,SpreadBonus,FireRate,-0.07,-0.06,D,4",
                                            "Target Cracker,Pistol,5,1,CritMultiplier,0.1,V,4",
                                            "Thermite Rounds,Rifle,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Thunderbolt,Rifle,0,1,FlatDamageBonus,2.0,V,9",
                                            "Toxic Barrage,Shotgun,3,2,ToxinDamage,StatusChance,0.15,0.15,V,4",
                                            "Toxic Sequence,Pistol,3,1,StatusDuration,0.5,D,4",
                                            "Trick Mag,Pistol,5,1,AmmoCap,0.15,~,2",
                                            "Vicious Spread,Shotgun,5,2,DamageBonus,SpreadBonus,0.15,0.1,V,4",
                                            "Vile Acceleration,Rifle,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
                                            "Vile Precision,Rifle,5,2,RecoilBonus,FireRate,-0.1,-0.06,~,6",
                                            "Vital Sense,Rifle,5,1,CritMultiplier,0.2,V,4",
                                            "Wildfire,Rifle,3,2,FireDamage,MagCap,0.15,0.05,V,6",
                                            "Automatic Trigger,ArcGun,5,1,FireRate,0.075,V,10",
                                            "Combustion Rounds,ArcGun,5,1,FireDamage,0.2,V,4",
                                            "Dual Rounds,ArcGun,5,1,Multishot,0.05,V,6",
                                            "Electrified Barrel,ArcGun,5,1,LightningDamage,0.2,~,4",
                                            "Hollowed Bullets,ArcGun,3,1,CritMultiplier,0.15,V,4",
                                            "Magazine Extension,ArcGun,5,1,MagCap,0.1,~,4",
                                            "Magma Chamber,ArcGun,3,2,FireDamage,StatusChance,0.15,0.15,V,4",
                                            "Modified Munitions,ArcGun,5,1,StatusChance,0.1,D,4",
                                            "Parallax Scope,ArcGun,3,1,CritChance,0.2,~,4",
                                            "Polar Magazine,ArcGun,5,1,IceDamage,0.2,D,4",
                                            "Rubedo-Lined Barrel,ArcGun,5,1,DamageBonus,0.1,V,6",
                                            "Venomous Clip,ArcGun,5,1,ToxinDamage,0.2,D,6"};
  
  /** Default Weapons for use if the file is missing **/
  public static final String[] baseWeapons = {"Rifle,Full-Auto,Physical,Attica,1.5,3,6.7,Attica,300,6.3,93.8,25,3.3,16,540,2.8,20,1.5,10,1",
                                              "Shotgun,Full-Auto,Physical,Boar Prime,,,,Boar Prime,,76.05,17.55,23.4,5.8,15,120,2.3,15,2,40,9",
                                              "Shotgun,Full-Auto,Physical,Boar,,,,Boar,,52.8,14.4,28.8,5,10,120,2.3,5,1.5,20,8",
                                              "Rifle,Full-Auto,Physical,Boltor Prime,,,,Boltor Prime,,5.5,49.5,0,10,60,540,2.4,5,2,10,1",
                                              "Rifle,Full-Auto,Physical,Boltor,,,,Boltor,,2.5,20.0,2.5,8.75,60,540,2.6,5,1.5,10,1",
                                              "Rifle,Full-Auto,Physical,Braton Prime,,,,Braton Prime,,1.8,12.3,21,9.58,75,540,2.2,10,2,20,1",
                                              "Rifle,Full-Auto,Physical,Braton Vandal,,,,Braton Vandal,,12.3,1.8,21,7.5,50,540,1.8,10,2,10,1",
                                              "Rifle,Full-Auto,Physical,Braton,,,,Braton,,6.6,6.6,6.8,8.75,45,540,2,10,1.5,5,1",
                                              "Rifle,Burst,Physical,Burston Prime,,3,25,Burston Prime,,11.7,11.7,15.6,10,45,540,2,5,1.5,15,1",
                                              "Rifle,Burst,Physical,Burston,,3,25,Burston,,10,10,10,5,45,540,2,10,1.5,10,1",
                                              "Rifle,Full-Auto,Physical,Buzlok,,3,25,Buzlok,,33.8,4.5,6.7,6.3,75,540,3,10,2,10,1",
                                              "Rifle,Charge,Physical,Cernos (Charged),1,3,6.7,Cernos (Charged),300,180,10,10,1,1,72,0.6,35,2,10,1",
                                              "Rifle,Semi-Auto,Physical,Cernos,1.5,3,6.7,Cernos,300,90,5,5,1,1,72,0.6,35,2,10,1",
                                              "Rifle,Charge,Physical,Daikyu,1.8,3,6.7,Daikyu,300,70,210,70,1,1,72,0.6,15,2,45,1",
                                              "Rifle,Full-Auto,Physical,Dera,,3,25,Dera,,4.4,16.5,1.1,11.3,45,540,2.37,10,1.5,10,1",
                                              "Shotgun,Charge,Physical,Drakgoon (Charge),1,,,Drakgoon (Charge),,25,25,200,3.33,7,120,2.3,7.5,2,10,10",
                                              "Shotgun,Semi-Auto,Physical,Drakgoon,,,,Drakgoon,,16,16,128,3.33,7,120,2.3,7.5,2,10,10",
                                              "Rifle,Charge,Physical,Dread (Charged),1,3,6.7,Dread (Charged),300,10,10,180,1,1,72,0.7,50,2,20,1",
                                              "Rifle,Semi-Auto,Physical,Dread,1.8,3,6.7,Dread,300,5,5,90,1,1,72,0.7,50,2,20,1",
                                              "Rifle,Continuous,Physical,Flux Rifle,,3,6.7,Flux Rifle,25,2.25,2.25,18,10,200,600,2,5,2,25,1",
                                              "Rifle,Continuous,Ice,Glaxion,,3,6.7,Glaxion,12.5,2.25,2.25,18,20,300,1500,1.5,5,2,35,1",
                                              "ifle,Full-Auto (Ramp-up),Physical,Gorgon Wraith,,3,25,Gorgon Wraith,,23,2.7,1.3,13.3,90,540,3,10,1.5,15,1",
                                              "Rifle,Full-Auto (Ramp-up),Physical,Gorgon,,3,25,Gorgon,,18.75,3.75,2.5,12.5,90,540,4.2,10,1.5,5,1",
                                              "Rifle,Full-Auto,Physical,Grakata,,3,25,Grakata,,4.4,3.7,2.9,20,60,750,2.4,25,2,20,1",
                                              "Shotgun,Semi-Auto,Physical,Hek,1,,,Hek,,26.25,113.75,35,2.2,4,120,2.2,10,2,25,7",
                                              "Rifle,Burst,Physical,Hind,,5,14,Hind,,7.5,7.5,15,5,65,470,2,5,1.5,10,1",
                                              "Rifle,Continuous,Fire,Ignis,,3,6.7,Ignis,10,2.25,2.25,18,10,100,540,2,5,2,10,1",
                                              "Rifle,Full-Auto,Physical,Karak Wraith,,5,14,Karak Wraith,,13.5,9,7.5,11.7,60,470,2,5,2,15,1",
                                              "Rifle,Full-Auto,Physical,Karak,,5,14,Karak,,12.1,8.1,6.8,11.7,30,470,2,2.5,1.5,7.5,1",
                                              "Shotgun,Full-Auto (Bullet-Ramp),Physical,Kohm,,,,Kohm,,72,72,216,3.7,245,960,2,10,2,300,12",
                                              "Rifle,Charge,Electric,Lanka (Charged),1.5,3,6.7,Lanka (Charged),300,2.25,2.25,18,1,10,72,2,25,2,25,1",
                                              "Rifle,Semi-Auto,Electric,Lanka,,3,6.7,Lanka,100,2.25,2.25,18,1,10,72,2,25,2,25,1",
                                              "Rifle,Semi-Auto,Physical,Latron Prime,,5,14,Latron Prime,,8.5,68,8.5,4.2,15,470,2.4,15,2.5,25,1",
                                              "Rifle,Semi-Auto,Physical,Latron Wraith,,5,14,Latron Wraith,,13.8,38.5,2.8,5.4,15,470,2.4,25,2.5,20,1",
                                              "Rifle,Semi-Auto,Physical,Latron,,5,14,Latron,,8.3,38.5,8.2,4.2,15,540,2.4,10,2,10,1",
                                              "Rifle,Charge,Physical,Miter (Charged),1.5,3,6.7,Miter (Charged),300,12.5,12.5,225,2.5,20,72,2,0,0,50,1",
                                              "Rifle,Semi-Auto,Physical,Miter,1,3,6.7,Miter,300,6.25,6.25,112.5,2.5,20,72,2,0,0,0,1",
                                              "Rifle,Full-Auto,Physical,MK1-Braton,,,,MK1-Braton,,4.5,4.5,9,7.5,60,450,2.0,8,1.5,5,1",
                                              "Rifle,Charge,Physical,MK1-Paris (Charged),0.5,3,6.7,MK1-Paris (Charged),300,6,96,18,1,1,72,0.6,30,2,10,1",
                                              "Rifle,Semi-Auto,Physical,MK1-Paris,1,3,6.7,MK1-Paris,300,3,48,9,1,1,72,0.6,30,1.5,10,1",
                                              "Rifle,Semi-Auto,Radiation,Mutalist Quanta Cubes,2.5,5,14,Mutalist Quanta Cubes,200,50,425,25,1,4,31,2,15,2,15,1",
                                              "Rifle,Full-Auto,Physical,Mutalist Quanta,,5,14,Mutalist Quanta,,2.5,15,7.5,10,60,470,3,2.5,1.5,15,1",
                                              "Rifle,Charge,Blast,Ogris,1.5,3,6.7,Ogris,650,6.25,6.25,112.5,1,5,20,2.5,5,2,10,1",
                                              "Rifle,Charge,Physical,Opticor (Charged),2.5,5,14,Opticor (Charged),,100,850,50,1,5,470,2,15,2,15,1",
                                              "Rifle,Charge,Physical,Opticor,1.25,5,14,Opticor,,50,425,25,1,5,540,2,15,2,15,1",
                                              "Rifle,Continuous,Physical,Panthera (Secondary Attack),1.5,3,6.7,Panthera (Secondary Attack),650,0,0,225,1.7,60,540,2,0,0,10,1",
                                              "Rifle,Semi-Auto,Physical,Panthera,1.5,3,6.7,Panthera,650,20,10,70,1.7,60,540,2,0,0,10,1",
                                              "Rifle,Burst,Toxin,Paracyt,,4,8.3,Paracyt,25,8.3,38.5,8.2,3.9,60,540,2,5,2,15,1",
                                              "Rifle,Charge,Physical,Paris (Charged),1,3,6.7,Paris (Charged),300,9,144,27,1,1,72,0.7,30,2,10,1",
                                              "Rifle,Charge,Physical,Paris Prime (Charged),1,3,6.7,Paris Prime (Charged),300,5,160,35,1,1,72,0.7,45,2,20,1",
                                              "Rifle,Semi-Auto,Physical,Paris Prime,0.5,3,6.7,Paris Prime,300,2.5,80,17.5,1,1,72,0.7,45,2,20,1",
                                              "Rifle,Semi-Auto,Physical,Paris,1,3,6.7,Paris,300,4.5,72,14.5,1,1,72,0.7,30,1.5,10,1",
                                              "Rifle,Semi-Auto,Physical,Penta (Grenade),1.5,3,6.7,Penta (Grenade),350,75,0,0,1,5,20,2.5,10,2,10,1",
                                              "Rifle,Semi-Auto,Blast,Penta,1.5,3,6.7,Penta,350,0,0,225,1,5,20,2.5,10,2,10,1",
                                              "Shotgun,Continuous,Viral,Phage,1,,,Phage,330,26.25,113.75,35,1,40,120,2,10,2,15,1",
                                              "Rifle,Full-Auto (Ramp-up),Physical,Prisma Gorgon,,3,25,Prisma Gorgon,,18.75,3.75,2.5,14.2,120,540,3,15,2,5,1",
                                              "Rifle,Full-Auto,Physical,Prisma Grakata,,3,25,Prisma Grakata,,4.4,3.7,2.9,21.7,120,1000,2,25,2.5,20,1",
                                              "Rifle,Semi-Auto,Blast,Quanta (Cubes),,3,6.7,Quanta (Cubes),200,2.25,2.25,18,1,6,54,2,10,2,10,1",
                                              "Rifle,Semi-Auto,Blast,Quanta Vandal (Cubes),,3,6.7,Quanta Vandal (Cubes),250,2.25,2.25,18,1,9,54,2,10,2,25,1",
                                              "Rifle,Continuous,Electric,Quanta Vandal,,3,6.7,Quanta Vandal,220,2.25,2.25,18,1,90,540,2,10,2,25,1",
                                              "Rifle,Continuous,Electric,Quanta,,3,6.7,Quanta,220,2.25,2.25,18,1,60,540,2,10,2,10,1",
                                              "Rifle,Semi-Auto,Physical,Snipetron Vandal,1.5,3,6.7,Snipetron Vandal,300,7.2,134.4,7.2,2,6,72,2,20,2,15,1",
                                              "Rifle,Semi-Auto,Physical,Snipetron,1.5,3,6.7,Snipetron,300,12.5,100,12.5,1.5,4,72,3.5,20,1.5,10,1",
                                              "Shotgun,Full-Auto,Physical,Sobek,1,,,Sobek,330,90,15,15,2.5,20,120,2,10,2,15,4",
                                              "Rifle,Full-Auto (Ramp-up),Physical,Soma Prime,,4,8.3,Soma Prime,25,1.2,4.8,6,15,200,800,3,30,3,10,1",
                                              "Rifle,Full-Auto (Ramp-up),Physical,Soma,,4,8.3,Soma,25,1,4,5,15,100,540,3,30,3,7,1",
                                              "Shotgun,Semi-Auto,Physical,Strun Wraith,1,,,Strun Wraith,330,97.5,22.5,30,2.5,8,120,1.5,15,2,40,10",
                                              "Shotgun,Semi-Auto,Physical,Strun,1,,,Strun,330,92.4,25.2,50.4,2.5,6,120,3,7.5,1.5,20,10",
                                              "Rifle,Full-Auto (Ramp-up),Physical,Super Supra,,4,8.3,Super Supra,25,105,78.9,37.5,12.5,90,540,4.2,2.5,1.5,2.5,1",
                                              "Rifle,Full-Auto (Ramp-up),Physical,Supra,,4,8.3,Supra,25,3.5,26.3,5.2,12.5,90,540,4.2,2.5,1.5,2.5,1",
                                              "Rifle,Burst,Physical,Sybaris,,2,3.3,Sybaris,25,23.1,23.1,23.8,2.4,10,540,2,25,2,10,1",
                                              "Rifle,Continuous,Electric,Synapse,,3,6.7,Synapse,12.5,2.25,2.25,18,10,100,540,1.5,50,2,10,1",
                                              "Rifle,Full-Auto,Physical,Tetra,,2,3.3,Tetra,25,6,24,0,6.7,60,540,2,2.5,1.5,10,1",
                                              "Rifle,Burst,Physical,Tiberon,,3,6.7,Tiberon,25,15,30,15,10,30,540,2.3,5,2,2.5,1",
                                              "Shotgun,Burst,Physical,Tigris,1,2,10,Tigris,330,20,20,160,2,2,120,1.8,5,2,25,4",
                                              "Rifle,Semi-Auto,Physical,Tonkor (Grenade),1.5,3,6.7,Tonkor (Grenade),325,0,75,0,2,2,20,2,35,2.5,10,1",
                                              "Rifle,Semi-Auto,Blast,Tonkor,1.5,3,6.7,Tonkor,325,75,0,0,2,2,20,2,35,2.5,10,1",
                                              "Rifle,Semi-Auto,Toxin,Torid (Grenade),1.5,3,6.7,Torid (Grenade),500,0,75,0,1,5,60,3,15,2,20,1",
                                              "Rifle,Semi-Auto,Physical,Vectis Prime,1.5,3,6.7,Vectis Prime,300,137,154,51,1,2,72,0.85,25,2,30,1",
                                              "Rifle,Semi-Auto,Physical,Vectis,1.5,3,6.7,Vectis,300,90,78.8,56.3,1.5,1,72,0.9,25,2,30,1",
                                              "Rifle,Semi-Auto,Physical,Vulkar,1.5,3,6.7,Vulkar,300,160,30,10,1.5,6,72,3,20,2,25,1",
                                              "Pistol,Semi-Auto,Toxin,Acrid,,,,Acrid,35,,,,6.7,15,210,1.2,5,2,10,1",
                                              "Pistol,Full-Auto,Physical,Afuris,,,,Afuris,,2.3,10.5,2.2,20,70,210,2.8,5,2,1,1",
                                              "Pistol,Semi-Auto,Physical,Akbolto,,,,Akbolto,,4.5,40.5,0,10,30,210,2.6,7.5,2,7.5,1",
                                              "Pistol,Semi-Auto,Physical,Akbronco Prime,,,,Akbronco Prime,,63,10.5,31.5,8.3,6,210,2.3,2.5,2,30,7",
                                              "Pistol,Semi-Auto,Physical,Akbronco,,,,Akbronco,,84,10.5,10.5,8.3,4,210,2.3,2.5,2,14,7",
                                              "Pistol,Semi-Auto,Physical,AkJagara,,,,AkJagara,,9,9,42,8.3,24,210,2.3,5,2,20,1",
                                              "Pistol,Semi-Auto,Physical,Aklato,,,,Aklato,,2.7,4.5,10.8,8.3,30,210,2.4,2.5,1.5,1,1",
                                              "Pistol,Semi-Auto,Physical,Aklex,,,,Aklex,,7,56,7,2,12,210,3,20,2,15,1",
                                              "Pistol,Semi-Auto,Physical,Akmagnus,,,,Akmagnus,,20.3,12.4,12.4,8.3,16,210,3,25,2,25,1",
                                              "Pistol,Full-Auto (Ramp-up),Physical,Aksomati,,,,Aksomati,,1.8,7.2,9,12.5,70,210,1.4,20,3,5,1",
                                              "Pistol,Full-Auto,Physical,Akstiletto,,,,Akstiletto,,10.8,1.8,5.4,10,28,210,1.1,15,1.5,15,1",
                                              "Pistol,Full-Auto,Physical,AkZani,,,,AkZani,,2,9.1,1.9,20,100,400,2,5,2,5,1",
                                              "Pistol,Semi-Auto,Blast,Angstrum (Single Rocket),,,,Angstrum (Single Rocket),425,,,,2,3,30,2.5,5,2,10,1",
                                              "Pistol,Continuous,Fire,Atmos,1,3,25,Atmos,50,9.6,1.6,4.8,5,50,210,2,5,1.5,10,1",
                                              "Pistol,Burst,Physical,Ballistica (Burst),1,4,3.33,Ballistica (Burst),425,2.5,20,2.5,6,16,210,2,15,1.5,10,1",
                                              "Pistol,Charge,Physical,Ballistica (Charge),1,4,,Ballistica (Charge),425,10,80,10,3.33,16,210,2,15,1.5,10,1",
                                              "Pistol,Semi-Auto,Physical,Bolto,1,4,3.33,Bolto,425,4.5,40.5,0,6.8,15,210,1.3,5,2,7.5,1",
                                              "Pistol,Semi-Auto,Physical,Brakk,1,3,25,Brakk,32,67.5,37.5,45,5,5,210,1,15,2,10,10",
                                              "Pistol,Semi-Auto,Physical,Bronco Prime,1,3,25,Bronco Prime,32,112,14,14,4.2,4,210,2,2.5,1.5,17.5,7",
                                              "Pistol,Semi-Auto,Physical,Bronco,1,3,25,Bronco,32,84,10.5,10.5,5,2,210,1,2.5,2,14,7",
                                              "Pistol,Semi-Auto,Electric,Castanas,,,,Castanas,100,14.4,1.8,1.8,5,2,210,1,5,1.5,10,1",
                                              "Pistol,Full-Auto (Ramp-up),Physical,Cestra,1,4,3.33,Cestra,425,5,20,0,8.3,60,210,2,2.5,2,5,1",
                                              "Pistol,Full-Auto,Physical,Despair,,,,Despair,115,2.75,44,8.25,3.3,10,210,0.8,2.5,1.5,2.5,1",
                                              "Pistol,Semi-Auto,Radiation,Detron,1,3,25,Detron,105,112,14,14,3.3,5,210,1,2.5,1.5,10,7",
                                              "Pistol,Full-Auto,Physical,Dex Furis,,,,Dex Furis,,2.3,10.5,2.2,20,100,210,2,7.5,2,5,1",
                                              "Pistol,Full-Auto (Ramp-up),Physical,Dual Cestra,,,,Dual Cestra,,5,20,0,12.5,100,210,3.5,2.5,1.5,5,1",
                                              "Pistol,Continuous,Toxin,Embolist,1,3,25,Embolist,18.5,9.6,1.6,4.8,10,100,210,1.5,2.5,2.0,10,1",
                                              "Pistol,Full-Auto,Physical,Furis,1,4,3.33,Furis,425,2.4,10.5,2.2,10,35,210,1.4,5,2,1,1",
                                              "Pistol,Continuous,Magnetic,Gammacor,1,3,25,Gammacor,50,9.6,1.6,4.8,5,50,210,2,5,1.5,5,1",
                                              "Pistol,Full-Auto,Physical,Hikou Prime,,,,Hikou Prime,115,3.1,27.2,1.6,5.8,26,210,0.5,2.5,1.5,15,1",
                                              "Pistol,Full-Auto,Physical,Hikou,,,,Hikou,115,2.5,15,7.5,6.7,20,210,0.8,2.5,1.5,2.5,1",
                                              "Pistol,Full-Auto (Bullet-Ramp),Physical,Kohmak,,,,Kohmak,,19.2,19.2,57.6,5,40,210,2,5,2,60,6",
                                              "Pistol,Burst,Physical,Kraken,1,2,22,Kraken,425,33.8,5.6,5.6,2.8,14,210,2.5,5,2,10,1",
                                              "Pistol,Full-Auto,Physical,Kunai,,,,Kunai,115,3.5,33.8,6.7,3.3,10,210,0.8,2.5,1.5,2.5,1",
                                              "Pistol,Semi-Auto,Physical,Lato Prime,1,2,22,Lato Prime,425,2,4,15,6.7,15,210,1.2,5,2,5,1",
                                              "Pistol,Semi-Auto,Physical,Lato Vandal,1,2,22,Lato Vandal,425,3,5,12,5,15,210,1.2,5,2,5,1",
                                              "Pistol,Semi-Auto,Physical,Lato,1,2,22,Lato,425,4.5,4.5,9,6.7,15,210,1,5,1.8,1,1",
                                              "Pistol,Semi-Auto,Physical,Lex Prime,1,2,22,Lex Prime,425,8.5,86,8.5,2.1,8,210,2.3,20,2,20,1",
                                              "Pistol,Semi-Auto,Physical,Lex,1,2,22,Lex,425,7,56,7,1.1,6,210,2.35,15,2,10,1",
                                              "Pistol,Semi-Auto,Physical,Magnus,1,2,22,Magnus,425,20.3,12.4,12.4,5.8,8,210,2,20,2,20,1",
                                              "Pistol,Semi-Auto,Radiation,Mara Detron,1,3,25,Mara Detron,105,112,14,14,3.2,8,210,1,2.5,1.5,10,7",
                                              "Pistol,Semi-Auto,Physical,Marelok,1,2,22,Marelok,425,80,16,64,2,6,210,1.7,15,1.5,30,1",
                                              "Pistol,Full-Auto,Physical,MK-1 Furis,1,4,3.33,MK-1 Furis,425,2,9.1,1.9,8.3,35,210,1.4,5,2,1,1",
                                              "Pistol,Full-Auto,Physical,MK1-Kunai,,,,MK1-Kunai,115,4,30,6,3.3,10,210,0.8,5,2,2.5,1",
                                              "Pistol,Continuous,Radiation,Nukor,1,3,25,Nukor,32,9.6,1.6,4.8,5,50,210,2,1,4,20,1",
                                              "Pistol,Semi-Auto,Physical,Pyrana,,,,Pyrana,,10.8,10.8,86.4,4.2,5,210,2,20,2,10,12",
                                              "Pistol,Burst,Physical,Rakta Ballistica (Burst),1,4,3.33,Rakta Ballistica (Burst),425,3.75,67.5,3.75,6,20,210,2,20,1.5,10,1",
                                              "Pistol,Charge,Physical,Rakta Ballistica (Charge),1,4,,Rakta Ballistica (Charge),425,15,270,15,3.33,20,210,2,20,1.5,10,1",
                                              "Pistol,Semi-Auto,Electric,Sancti Castanas,,,,Sancti Castanas,115,14.4,1.8,1.8,5,2,210,1,10,1.5,15,1",
                                              "Pistol,Full-Auto (Ramp-up),Physical,Secura Dual Cestra,,,,Secura Dual Cestra,,6,24,0,12.5,100,210,3.5,5,1.5,7.5,1",
                                              "Pistol,Semi-Auto,Physical,Seer,1,2,22,Seer,425,28,28,28,2,8,210,2.8,0,0,10,1",
                                              "Pistol,Burst,Physical,Sicarus Prime,1,3,25,Sicarus Prime,425,12.8,9.6,9.6,5,21,210,2,10,1.5,10,1",
                                              "Pistol,Burst,Physical,Sicarus,1,3,25,Sicarus,425,21,4.5,4.5,3.5,15,210,2,10,2,2.5,1",
                                              "Pistol,Continuous,Physical,Spectra,1,3,25,Spectra,32,3,21,6,5,80,210,2,5,2,20,1",
                                              "Pistol,Charge,Corrosive,Stug (Charge),3,3,25,Stug (Charge),936,12.8,9.6,9.6,8.33,20,210,2,5,1.5,0,1",
                                              "Pistol,Semi-Auto,Corrosive,Stug,1,3,25,Stug,156,12.8,9.6,9.6,8.33,20,210,2,5,1.5,0,1",
                                              "Pistol,Continuous,Magnetic,Synoid Gammacor,1,3,25,Synoid Gammacor,28,9.6,1.6,4.8,15,150,210,2,10,2,20,1",
                                              "Pistol,Semi-Auto,Physical,Telos Akbolto,,,,Telos Akbolto,,5,45,0,10,30,210,2.6,10,2,12.5,1",
                                              "Pistol,Full-Auto,Physical,Twin Gremlins,,,,Twin Gremlins,,10,10,10,5,30,210,2,10,1.5,10,1",
                                              "Pistol,Full-Auto,Physical,Twin Vipers,,,,Twin Vipers,,9.6,1.6,4.8,25,28,210,2,15,1.5,1,1",
                                              "Pistol,Semi-Auto,Corrosive,Tysis,3,3,25,Tysis,35,12.8,9.6,9.6,8.33,15,210,1.2,2.5,1.5,50,1",
                                              "Pistol,Semi-Auto,Physical,Vasto Prime,1,3,25,Vasto Prime,156,9,9,42,5.4,6,210,1,15,2,15,1",
                                              "Pistol,Semi-Auto,Physical,Vasto,1,3,25,Vasto,156,12.5,12.5,25,5,6,210,1,15,1.5,5,1",
                                              "Pistol,Semi-Auto,Physical,Vaykor Marelok,1,2,22,Vaykor Marelok,425,96,16,48,2,10,210,1.7,20,1.5,35,1",
                                              "Pistol,Full-Auto,Physical,Viper,1,3,25,Viper,156,9.6,1.6,4.8,14.4,14,210,1.1,15,1.5,1,1",
                                              "Pistol,Full-Auto,Physical,Wraith Twin Vipers,,,,Wraith Twin Vipers,,14.4,1.8,1.8,25,40,210,2,18,2,5,1"};
}
