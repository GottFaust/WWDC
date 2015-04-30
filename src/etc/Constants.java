package etc;

import java.awt.Color;

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
  public static final String APP_VERSION = "v0.6.9";
  
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
  
  /** Default TTK Targets **/
  public static final String[] baseTTKTargets = { "Corpus Tech,15,95,0,700,250,CorpusFlesh,FerriteArmor,ProtoShield,Corpus",
                                                  "Toxic Ancient,1,95,0,400,0,Fossilized,FerriteArmor,Shields,Infested",
                                                  "Heavy Gunner,8,95,500,300,0,CloneFlesh,FerriteArmor,Shields,Grineer",
                                                  "Fusion Moa,15,95,0,250,250,Robotic,FerriteArmor,Shields,Corpus"};
  
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
                                            "Frail Momemtum,Shotgun,5,2,FireRate,DamageBonus,0.15,-0.025,V,4",
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
                                            "Wildfire,Rifle,3,2,FireDamage,MagCap,0.15,0.05,V,6"};
}
