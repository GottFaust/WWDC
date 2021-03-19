package etc;

public class Constants {
  
  /** Mod Type Constants **/
  public static final String MOD_TYPE_DAMAGE_BONUS = "Damage";
  public static final String MOD_TYPE_FIRE_DAMAGE = "FireDamage";
  public static final String MOD_TYPE_LIGHTNING_DAMAGE = "ElectricDamage";
  public static final String MOD_TYPE_ICE_DAMAGE = "IceDamage";
  public static final String MOD_TYPE_PUNCTURE_DAMAGE = "PunctureDamage";
  public static final String MOD_TYPE_TOXIN_DAMAGE = "ToxinDamage";
  public static final String MOD_TYPE_IMPACT_DAMAGE = "ImpactDamage";
  public static final String MOD_TYPE_SLASH_DAMAGE = "SlashDamage";
  public static final String MOD_TYPE_MISC_DAMAGE = "MiscDamage";
  public static final String MOD_TYPE_MULTISHOT = "Multishot";
  public static final String MOD_TYPE_FIRE_RATE = "FireRate";
  public static final String MOD_TYPE_RELOAD_SPEED = "ReloadSpeed";
  public static final String MOD_TYPE_MAG_CAP = "MagCap";
  public static final String MOD_TYPE_AMMO_CAP = "AmmoCap";
  public static final String MOD_TYPE_CORPUS_DAMAGE = "CorpusDamage";
  public static final String MOD_TYPE_GRINEER_DAMAGE = "GrineerDamage";
  public static final String MOD_TYPE_CORRUPTED_DAMAGE = "CorruptedDamage";
  public static final String MOD_TYPE_INFESTED_DAMAGE = "InfestedDamage";
  public static final String MOD_TYPE_CRIT_CHANCE = "CritChance";
  public static final String MOD_TYPE_CRIT_MULTIPLIER = "CritMultiplier";
  public static final String MOD_TYPE_STATUS_CHANCE = "StatusChance";
  public static final String MOD_TYPE_STATUS_DURATION = "StatusDuration";
  public static final String MOD_TYPE_FIRST_SHOT_DAMAGE = "FirstShotDamage";
  public static final String MOD_TYPE_LAST_SHOT_DAMAGE = "LastShotDamage";
  public static final String MOD_TYPE_ZOOM = "Zoom";
  public static final String MOD_TYPE_OBJECT_PIERCE = "PunchThrough";
  public static final String MOD_TYPE_AMMO_MUTATOR = "AmmoMutator";
  public static final String MOD_TYPE_ACCURACY = "AccuracyBonus";
  public static final String MOD_TYPE_RECOIL = "RecoilBonus";
  public static final String MOD_TYPE_SPREAD = "SpreadBonus";
  public static final String MOD_TYPE_SILENCE = "Silence";
  public static final String MOD_TYPE_FLAT_DAMAGE = "FlatDamage";
  public static final String MOD_TYPE_DEAD_AIM = "DeadAim";
  public static final String MOD_TYPE_FLAT_STATUS = "FlatStatusBonus";
  public static final String MOD_TYPE_FLAT_MAG = "FlatMagBonus";
  public static final String MOD_TYPE_MUNITIONS = "Munitions";
  public static final String MOD_TYPE_VIGILANTE = "VigilanteEffect";
  public static final String MOD_TYPE_COMBO_DURATION = "ComboDuration";
  public static final String MOD_TYPE_COMBO_CRIT = "ComboCrit";
  public static final String MOD_TYPE_COMBO_STATUS = "ComboStatus";
  public static final String MOD_TYPE_CONDITION_OVERLOAD = "DamagePerStatus";
  public static final String MOD_TYPE_ADDITIVE_CC = "AdditiveCritChance";
  public static final String MOD_TYPE_SHATTERING_IMPACT = "ShatteringImpact";
  public static final String MOD_TYPE_MULTI_RATE = "FireRate(Multiplicative)";
  public static final String MOD_TYPE_RANGE = "Range";
  public static final String MOD_TYPE_PFS = "FlightSpeed";
  public static final String MOD_TYPE_IMPACTSLASH = "ImpactSlashStatus";
  
  /** Sniper scope effects **/
  public static final String ADDITIVE_CRIT_CHANCE = "Scoped CC";
  public static final String ADDITIVE_CRIT_DAMAGE = "Scoped CD";
  public static final String HEADSHOT_BONUS = "Headshot Dmg";
  
  /** Damage Types **/
  public static final String PHYSICAL_WEAPON_DAMAGE = "No Element";
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
  public static final String SNIPER = "Sniper (Semi-Auto)";
  public static final String LANKA = "Sniper (Charge)";
  public static final String SEMIBOW = "Bow (Semi-Auto)";
  public static final String CHARGEBOW = "Bow (Charge)";
  public static final String AUTOBOW = "Bow (Full-Auto)";
  
  public static final String[] gunModes = {
		  BURST,
		  CHARGE,
		  CONTINUOUS,
		  FULL_AUTO,
		  FULL_AUTO_RAMP_UP,
		  FULL_AUTO_BULLET_RAMP,
		  SEMI_AUTO,
		  SNIPER,
		  LANKA,
		  SEMIBOW,
		  CHARGEBOW,
		  AUTOBOW
  };
  
  /** Melee types **/
  public static final String BLADEWHIP = "Blade and Whip";
  public static final String CLAWS = "Claws";
  public static final String DAGGER = "Dagger";
  public static final String DUALDAGGERS = "Dual Daggers";
  public static final String DUALSWORDS = "Dual Swords";
  public static final String FIST = "Fist";
  public static final String GLAIVE = "Glaive";
  public static final String GUNBLADE = "Gunblade";
  public static final String HAMMER = "Hammer";
  public static final String HEAVYBLADE = "Heavy Blade";
  public static final String MACHETE = "Machete";
  public static final String NIKANA = "Nikana";
  public static final String NUNCHAKU = "Nunchaku";
  public static final String POLEARM = "Polearm";
  public static final String RAPIER = "Rapier";
  public static final String SCYTHE = "Scythe";
  public static final String SPARRING = "Sparring";
  public static final String STAFF = "Staff";
  public static final String SWORD = "Sword";
  public static final String SWORDSHIELD = "Sword and Shield";
  public static final String TONFA = "Tonfa";
  public static final String TWOHANDER = "Two-Handed Nikana";
  public static final String WARFANS = "Warfans";
  public static final String WHIP = "Whip";
  
  public static final String[] meleeTypes = {
		BLADEWHIP,
		CLAWS,
		DAGGER,
		DUALDAGGERS,
		DUALSWORDS,
		FIST,
		GLAIVE,
		GUNBLADE,
		HAMMER,
		HEAVYBLADE,
		MACHETE,
		NIKANA,
		NUNCHAKU,
		POLEARM,
		RAPIER,
		SCYTHE,
		SPARRING,
		STAFF,
		SWORD,
		SWORDSHIELD,
		TONFA,
		TWOHANDER,
		WARFANS,
		WHIP
  };
  
  /** Frame Title **/
  public static final String APP_TITLE = "Warframe Weapon DPS Calculator";
  public static final String APP_VERSION = "v0.13.11";
  
  /** ToolTips **/
  public static final String NAME_TOOL_TIP = "The weapon's name.";
  public static final String DAMAGE_TOOL_TIP = "The weapon's base damage.";
  public static final String IMPACT_TOOL_TIP = "The weapon's impact damage.";
  public static final String PUNCTURE_TOOL_TIP = "The weapon's puncture damage.";
  public static final String SLASH_TOOL_TIP = "The weapon's slash damage.";
  public static final String POJECTILE_TOOL_TIP = "The number of projectiles fired per shot";
  public static final String CONTINUOUS_DAMAGE_TOOL_TIP = "The base damage displayed by the weapon.";
  public static final String FIRE_RATE_TOOL_TIP = "The weapon's fire rate in bullets per second. Leave 0 for most bows";
  public static final String MAG_SIZE_TOOL_TIP = "<HTML>The weapon's magazine size. <br>Depending on the weapon, this can also be referred to as clip size.<HTML>";
  public static final String COMBO_TOOL_TIP = "The minimum shots required to start the sniper's combo multiplier. MUST be lower than 7";
  public static final String RELOAD_TIME_TOOL_TIP = "The weapon's reload time in seconds";
  public static final String CRIT_CHANCE_TOOL_TIP = "<HTML>The weapon's critical chance in whole number percents. <br>For example, the Lanka has a 25 base crit chance.</HTML>";
  public static final String CRIT_MULT_TOOL_TIP = "<HTML>The Weapon's critical damage multiplier in decimal format. <br>For example, the Lanka has a 2.0 base crit multiplier.</HTML>";
  public static final String WEAPON_MODE_TOOL_TIP = "The weapon's mode of operation.";
  public static final String DAMAGE_TYPE_TOOL_TIP = "<HTML>The type of base damage that this weapon does. <br>This info can be obtained most easily from the warframe wiki.</HTML>";
  public static final String CHARGE_TIME_TOOL_TIP = "The time it takes the weapon to charge before being able to fire.";
  public static final String BURST_COUNT_TOOL_TIP = "The number of bullets fired in each burst.";
  public static final String BURST_FIRE_RATE_TOOL_TIP = "The rate of fire during each burst iteration";
  public static final String STATUS_TOOL_TIP = "The base status chance of this weapon.";
  
  public static final String STANCE_AU_TIP = "Adds a new stance if it has a new name. Updates the stance otherwise.";
  public static final String COMBO_AU_TIP = "Adds a new combo if it has a new name. Updates the combo otherwise.";
  
  /** Weapon Types **/
  public static final String SHOTGUN = "Shotgun";
  public static final String RIFLE = "Rifle";
  public static final String PISTOL = "Pistol";
  public static final String ARCHGUN = "ArchGun";
  public static final String MELEE = "Melee";
  
  /** Mod Effect Count **/
  public static final String SINGLE = "Single";
  public static final String DOUBLE = "Double";
  public static final String TRIPLE = "Triple";
  public static final String QUAD = "Quad";
  
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
  public static final String ENEMY_TYPE_CORRUPTED = "Corrupted";
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
  public static final String[] baseTTKTargets = { "Corrupted Butcher,1,95,5,100,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted Lancer,1,95,200,60,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted Crewman,1,95,0,60,150,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted Nullifier,1,95,0,60,150,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted MOA,1,95,0,250,250,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted Ancient,1,95,0,400,0,"+ENEMY_SURFACE_FOSSILIZED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted Heavy Gunner,8,95,500,700,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4;0",
          "Corrupted Bombard,4,95,500,300,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4;0",
          "Corrupted Heavy Gunner Leech Eximus,8,95,800,2100,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4",
          "Corrupted Bombard Leech Eximus,4,95,800,900,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORRUPTED+",4",
          "Butcher,1,95,5,50,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Scorpion,10,95,150,150,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Elite Lancer,15,95,200,150,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Trooper,1,95,150,120,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Ballista,1,95,100,100,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Scorch,10,95,100,120,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Seeker,1,95,200,100,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Drahk Master,12,95,200,500,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Drahk,1,95,175,300,0,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Napalm,6,95,500,600,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Heavy Gunner,8,95,500,300,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Bombard,1,95,500,300,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Napalm Leech Eximus,6,95,800,1800,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Heavy Gunner Leech Eximus,8,95,800,900,0,"+ENEMY_SURFACE_CLONE_FLESH+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_GRINEER+",1",
          "Prod Crewman,1,95,0,100,50,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Crewman,1,95,0,60,150,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Sniper Crewman,1,95,0,60,150,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORPUS+",2",
          "Elite Crewman,15,95,0,100,200,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Corpus Tech,15,95,0,700,250,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORPUS+",2;0",
          "Nullifer Crewman,1,95,0,600,150,"+ENEMY_SURFACE_CORPUS_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_CORPUS+",2",
          "MOA,1,95,0,60,150,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Fusion MOA,15,95,0,250,250,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Fusion MOA Drone,15,95,0,250,75,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Anti MOA,5,95,0,50,500,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Oxium Osprey,5,95,40,750,150,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Bursa,1,95,200,1200,700,"+ENEMY_SURFACE_ROBOTIC+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_SHIELDS+","+ENEMY_TYPE_CORPUS+",2",
          "Charger,1,95,0,80,0,"+ENEMY_SURFACE_INFESTED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Volatile Runner,1,95,0,80,0,"+ENEMY_SURFACE_INFESTED_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Runner,1,95,0,100,0,"+ENEMY_SURFACE_INFESTED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Crawler,1,95,0,50,0,"+ENEMY_SURFACE_INFESTED_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Ancient,1,95,0,400,0,"+ENEMY_SURFACE_FOSSILIZED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Mutalist Osprey,1,95,0,200,0,"+ENEMY_SURFACE_INFESTED_FLESH+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Mutalist MOA,0,95,0,350,0,"+ENEMY_SURFACE_FOSSILIZED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Brood Mother,1,95,0,700,0,"+ENEMY_SURFACE_FOSSILIZED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Boiler,1,95,0,1200,0,"+ENEMY_SURFACE_FOSSILIZED+","+ENEMY_SURFACE_ALLOY_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3",
          "Juggernaut,1,95,200,3500,0,"+ENEMY_SURFACE_INFESTED+","+ENEMY_SURFACE_FERRITE_ARMOR+","+ENEMY_SURFACE_PROTO_SHIELD+","+ENEMY_TYPE_INFESTED+",3"};

/** The Default Mod DB for use if the file is missing **/
public static final String[] baseModDB = {
	"Accelerated Blast,"+SHOTGUN+",3,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_PUNCTURE_DAMAGE+",0.15,0.15,V,6,None,false",
    "Ammo Drum,"+RIFLE+",5,1,"+MOD_TYPE_AMMO_CAP+",0.05,~,2,None,true",
    "Ammo Stock,"+SHOTGUN+",5,1,"+MOD_TYPE_MAG_CAP+",0.1,~,2,None,false",
    "Anemic Agility,"+PISTOL+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_DAMAGE_BONUS+",0.15,-0.025,~,4,None,false",
    "Arrow Mutation,"+RIFLE+",3,1,"+MOD_TYPE_AMMO_MUTATOR+",0.0,~,4,None,true",
    "Bane of Corpus,"+RIFLE+",5,1,"+MOD_TYPE_CORPUS_DAMAGE+",0.05,V,4,None,false",
    "Bane of Grineer,"+RIFLE+",5,1,"+MOD_TYPE_GRINEER_DAMAGE+",0.05,V,4,None,false",
    "Bane of Corrupted,"+RIFLE+",5,1,"+MOD_TYPE_CORRUPTED_DAMAGE+",0.05,V,4,None,false",
    "Bane of Infested,"+RIFLE+",5,1,"+MOD_TYPE_INFESTED_DAMAGE+",0.05,V,4,None,false",
    "Barrel Diffusion,"+PISTOL+",5,1,"+MOD_TYPE_MULTISHOT+",0.2,V,6,None,false",
    "Blaze,"+SHOTGUN+",3,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_FIRE_DAMAGE+",0.15,0.15,V,6,None,false",
    "Blunderbuss,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.15,V,4,None,false",
    "Bore,"+PISTOL+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.2,~,6,None,false",
    "Breach Loader,"+SHOTGUN+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.2,~,6,None,false",
    "Burdened Magazine,"+SHOTGUN+",5,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_RELOAD_SPEED+",0.1,-0.03,~,6,None,false",
    "Charged Chamber,"+RIFLE+",3,1,"+MOD_TYPE_FIRST_SHOT_DAMAGE+",0.1,V,6,None,false",
    "Synth Charge,"+PISTOL+",3,1,"+MOD_TYPE_LAST_SHOT_DAMAGE+",0.5,V,6,None,false",
    "Charged Shell,"+SHOTGUN+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
    "Primed Charged Shell,"+SHOTGUN+",10,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
    "Chilling Grasp,"+SHOTGUN+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
    "Cleanse Corpus,"+SHOTGUN+",5,1,"+MOD_TYPE_CORPUS_DAMAGE+",0.05,V,4,None,false",
    "Cleanse Grineer,"+SHOTGUN+",5,1,"+MOD_TYPE_GRINEER_DAMAGE+",0.05,V,4,None,false",
    "Cleanse Corrupted,"+SHOTGUN+",5,1,"+MOD_TYPE_CORRUPTED_DAMAGE+",0.05,V,4,None,false",
    "Cleanse Infested,"+SHOTGUN+",5,1,"+MOD_TYPE_INFESTED_DAMAGE+",0.05,V,4,None,false",
    "Concussion Rounds,"+PISTOL+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.1,~,2,None,false",
    "Contagious Spread,"+SHOTGUN+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
    "Continuous Misery,"+RIFLE+",3,1,"+MOD_TYPE_STATUS_DURATION+",0.25,V,4,None,false",
    "Convulsion,"+PISTOL+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
    "Crash Course,"+RIFLE+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.2,~,6,None,false",
    "Creeping Bullseye,"+PISTOL+",5,2,"+MOD_TYPE_CRIT_CHANCE+","+MOD_TYPE_FIRE_RATE+",0.08,-0.06,~,4,None,false",
    "Critical Deceleration,"+SHOTGUN+",5,2,"+MOD_TYPE_CRIT_CHANCE+","+MOD_TYPE_FIRE_RATE+",0.08,-0.05,V,4,None,false",
    "Critical Delay,"+RIFLE+",5,2,"+MOD_TYPE_CRIT_CHANCE+","+MOD_TYPE_FIRE_RATE+",0.08,-0.06,~,4,None,false",
    "Cryo Rounds,"+RIFLE+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
    "Deadly Sequence,"+RIFLE+",3,1,"+MOD_TYPE_CRIT_CHANCE+",0.5,V,4,Prisma Grinlok,false",
    "Deep Freeze,"+PISTOL+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
    "Disruptor,"+SHOTGUN+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.05,~,4,None,false",
    "Eagle Eye,"+RIFLE+",3,1,"+MOD_TYPE_ZOOM+",0.0,~,4,None,true",
    "Entropy Burst,"+RIFLE+",3,1,"+MOD_TYPE_FLAT_STATUS+",0.05,V,4,Supra Vandal,false",
    "Erroding Blight,"+PISTOL+",3,1,"+MOD_TYPE_MAG_CAP+",0.5,D,4,None,false",
    "Expel Corpus,"+PISTOL+",5,1,"+MOD_TYPE_CORPUS_DAMAGE+",0.05,V,4,None,false",
    "Expel Grineer,"+PISTOL+",5,1,"+MOD_TYPE_GRINEER_DAMAGE+",0.05,V,4,None,false",
    "Expel Corrupted,"+PISTOL+",5,1,"+MOD_TYPE_CORRUPTED_DAMAGE+",0.05,V,4,None,false",
    "Expel Infested,"+PISTOL+",5,1,"+MOD_TYPE_INFESTED_DAMAGE+",0.05,V,4,None,false",
    "Primed Expel Corpus,"+PISTOL+",10,1,"+MOD_TYPE_CORPUS_DAMAGE+",0.05,V,4,None,false",
    "Primed Expel Grineer,"+PISTOL+",10,1,"+MOD_TYPE_GRINEER_DAMAGE+",0.05,V,4,None,false",
    "Primed Expel Corrupted,"+PISTOL+",10,1,"+MOD_TYPE_CORRUPTED_DAMAGE+",0.05,V,4,None,false",
    "Primed Expel Infested,"+PISTOL+",10,1,"+MOD_TYPE_INFESTED_DAMAGE+",0.05,V,4,None,false",
    "Fanged Fusillade,"+RIFLE+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.2,~,6,None,false",
    "Fast Hands,"+RIFLE+",5,1,"+MOD_TYPE_RELOAD_SPEED+",0.05,~,2,None,false",
    "Firestorm,"+RIFLE+",3,1,"+MOD_TYPE_MISC_DAMAGE+",0.0,V,6,None,false",
    "Flechette,"+SHOTGUN+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.05,~,4,None,false",
    "Frail Momentum,"+SHOTGUN+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_DAMAGE_BONUS+",0.15,-0.025,V,4,None,false",
    "Fridgid Blast,"+SHOTGUN+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Frostbite,"+PISTOL+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Full Contact,"+SHOTGUN+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.2,~,6,None,false",
    "Gilded Truth,"+RIFLE+",3,1,"+MOD_TYPE_FIRE_RATE+",0.2,V,4,Burston Prime,false",
    "Gunslinger,"+PISTOL+",5,1,"+MOD_TYPE_FIRE_RATE+",0.12,V,4,None,false",
    "Hammer Shot,"+RIFLE+",3,2,"+MOD_TYPE_STATUS_CHANCE+","+MOD_TYPE_CRIT_MULTIPLIER+",0.2,0.15,D,6,None,false",
    "Hawk Eye,"+PISTOL+",3,1,"+MOD_TYPE_ZOOM+",0.0,~,4,None,false",
    "Heated Charge,"+PISTOL+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
    "Heavy Caliber,"+RIFLE+",10,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_ACCURACY+",0.15,-0.05,V,6,None,false",
    "Hell's Chamber,"+SHOTGUN+",5,1,"+MOD_TYPE_MULTISHOT+",0.2,V,10,None,false",
    "Hellfire,"+RIFLE+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
    "High Voltage,"+RIFLE+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Hollow Point,"+PISTOL+",5,2,"+MOD_TYPE_CRIT_MULTIPLIER+","+MOD_TYPE_DAMAGE_BONUS+",0.1,-0.025,~,4,None,false",
    "Hornet Strike,"+PISTOL+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.2,V,4,None,false",
    "Hush,"+RIFLE+",3,1,"+MOD_TYPE_SILENCE+",0.25,~,2,None,true",
    "Ice Storm,"+PISTOL+",3,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_ICE_DAMAGE+",0.1,0.1,V,6,None,false",
    "Incendiary Coat,"+SHOTGUN+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
    "Infected Clip,"+RIFLE+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
    "Jolt,"+PISTOL+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Lasting Purity,"+RIFLE+",3,1,DeadAim,0.15,~,4,Vulkar Wraith,false",
    "Lethal Torrent,"+PISTOL+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_MULTISHOT+",0.1,0.1,V,6,None,false",
    "Lingering Torment,"+SHOTGUN+",5,1,"+MOD_TYPE_STATUS_DURATION+",0.05,V,6,None,false",
    "Magazine Warp,"+RIFLE+",5,1,"+MOD_TYPE_MAG_CAP+",0.05,~,4,None,false",
    "Magnum Force,"+PISTOL+",10,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_ACCURACY+",0.15,-0.05,V,4,None,false",
    "Maim,"+PISTOL+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.2,~,6,None,false",
    "Malignant Force,"+RIFLE+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Metal Auger,"+RIFLE+",5,1,"+MOD_TYPE_OBJECT_PIERCE+",0.0,~,10,None,false",
    "No Return,"+PISTOL+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.1,~,2,None,false",
    "Pathogen Rounds,"+PISTOL+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
    "Perpetual Agony,"+PISTOL+",5,1,"+MOD_TYPE_STATUS_DURATION+",0.05,V,6,None,false",
    "Piercing Caliber,"+RIFLE+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.2,~,6,None,false",
    "Piercing Hit,"+RIFLE+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.05,~,4,None,false",
    "Pistol Gambit,"+PISTOL+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.2,V,4,None,false",
    "Pistol Mutation,"+PISTOL+",3,1,"+MOD_TYPE_AMMO_MUTATOR+",0.0,~,4,None,true",
    "Pistol Pestilence,"+PISTOL+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Point Blank,"+SHOTGUN+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
    "Point Strike,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.25,V,4,None,false",
    "Primed Chamber,"+RIFLE+",3,1,"+MOD_TYPE_FIRST_SHOT_DAMAGE+",0.25,V,4,None,false",
    "Primed Fast Hands,"+RIFLE+",10,1,"+MOD_TYPE_RELOAD_SPEED+",0.05,~,2,None,false",
    "Primed Heated Charge,"+PISTOL+",10,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
    "Primed Pistol Gambit,"+PISTOL+",10,1,"+MOD_TYPE_CRIT_CHANCE+",0.17,V,2,None,false",
    "Primed Point Blank,"+SHOTGUN+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
    "Primed Ravage,"+SHOTGUN+",10,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.1,V,4,None,false",
    "Quickdraw,"+PISTOL+",5,1,"+MOD_TYPE_RELOAD_SPEED+",0.08,~,2,None,false",
    "Ravage,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.1,V,4,None,false",
    "Razor Shot,"+PISTOL+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.1,~,2,None,false",
    "Rifle Aptitude,"+RIFLE+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,4,None,false",
    "Rifle Mutation,"+RIFLE+",3,1,"+MOD_TYPE_AMMO_MUTATOR+",0.0,~,4,None,true",
    "Rime Rounds,"+RIFLE+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Rupture,"+RIFLE+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.05,~,4,None,false",
    "Sawtooth Clip,"+RIFLE+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.05,~,4,None,false",
    "Scattered Justice,"+SHOTGUN+",3,1,"+MOD_TYPE_MULTISHOT+",0.5,V,4,Hek,false",
    "Scattering Inferno,"+SHOTGUN+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Scorch,"+PISTOL+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Seeker,"+PISTOL+",5,1,"+MOD_TYPE_OBJECT_PIERCE+",0.0,~,10,None,false",
    "Seeking Force,"+SHOTGUN+",5,1,"+MOD_TYPE_OBJECT_PIERCE+",0.0,~,10,None,false",
    "Seeking Fury,"+SHOTGUN+",5,2,"+MOD_TYPE_OBJECT_PIERCE+","+MOD_TYPE_RELOAD_SPEED+",0.002,0.025,V,6,None,false",
    "Serration,"+RIFLE+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
    "Shattering Justice,"+SHOTGUN+",3,1,"+MOD_TYPE_FLAT_STATUS+",0.05,~,4,Sobek,false",
    "Shell Compression,"+SHOTGUN+",5,1,"+MOD_TYPE_AMMO_CAP+",0.05,~,2,None,true",
    "Shell Shock,"+SHOTGUN+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Shotgun Mutation,"+SHOTGUN+",3,1,"+MOD_TYPE_AMMO_MUTATOR+",0.0,~,4,None,true",
    "Shotgun Savvy,"+SHOTGUN+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,4,None,false",
    "Shotgun Spazz,"+SHOTGUN+",5,1,"+MOD_TYPE_FIRE_RATE+",0.15,V,4,None,false",
    "Shred,"+RIFLE+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_OBJECT_PIERCE+",0.05,0.0,V,6,None,false",
    "Shredder,"+SHOTGUN+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.05,~,4,None,false",
    "Slip Magazine,"+PISTOL+",5,1,"+MOD_TYPE_MAG_CAP+",0.05,~,4,None,false",
    "Sniper Mutation,"+RIFLE+",3,1,"+MOD_TYPE_AMMO_MUTATOR+",0.0,~,4,None,true",
    "Speed Trigger,"+RIFLE+",5,1,"+MOD_TYPE_FIRE_RATE+",0.1,V,4,None,false",
    "Split Chamber,"+RIFLE+",5,1,"+MOD_TYPE_MULTISHOT+",0.15,V,10,None,false",
    "Stabilizer,"+RIFLE+",3,1,"+MOD_TYPE_RECOIL+",-0.15,~,6,None,true",
    "Steady hands,"+PISTOL+",3,1,"+MOD_TYPE_RECOIL+",-0.15,~,6,None,true",
    "Stinging Truth,"+PISTOL+",3,1,"+MOD_TYPE_FLAT_MAG+",0.1,D,4,Viper Wraith,false",
    "Stormbringer,"+RIFLE+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
    "Stunning Speed,"+PISTOL+",3,2,"+MOD_TYPE_STATUS_CHANCE+","+MOD_TYPE_RELOAD_SPEED+",0.075,0.1,~,6,None,false",
    "Suppress,"+PISTOL+",3,1,"+MOD_TYPE_SILENCE+",0.25,~,2,None,true",
    "Sure Shot,"+PISTOL+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,2,None,false",
    "Sweeping Serration,"+SHOTGUN+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.2,~,6,None,false",
    "Tactical Pump,"+SHOTGUN+",5,1,"+MOD_TYPE_RELOAD_SPEED+",0.05,~,2,None,false",
    "Tainted Clip,"+PISTOL+",5,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_RELOAD_SPEED+",0.1,-0.05,~,6,None,false",
    "Tainted Mag,"+RIFLE+",10,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_RELOAD_SPEED+",0.06,-0.03,~,4,None,false",
    "Tainted Shell,"+SHOTGUN+",10,2,"+MOD_TYPE_SPREAD+","+MOD_TYPE_FIRE_RATE+",-0.07,-0.06,D,4,None,false",
    "Target Cracker,"+PISTOL+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.1,V,4,None,false",
    "Thermite Rounds,"+RIFLE+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Thunderbolt,"+RIFLE+",0,1,"+MOD_TYPE_FLAT_DAMAGE+",2.0,V,9,None,false",
    "Toxic Barrage,"+SHOTGUN+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Toxic Sequence,"+PISTOL+",3,1,"+MOD_TYPE_STATUS_DURATION+",0.5,D,4,Acrid,false",
    "Trick Mag,"+PISTOL+",5,1,"+MOD_TYPE_AMMO_CAP+",0.15,~,2,None,true",
    "Vicious Spread,"+SHOTGUN+",5,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_SPREAD+",0.15,0.1,V,4,None,false",
    "Vile Acceleration,"+RIFLE+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_DAMAGE_BONUS+",0.15,-0.025,V,4,None,false",
    "Vile Precision,"+RIFLE+",5,2,"+MOD_TYPE_RECOIL+","+MOD_TYPE_FIRE_RATE+",-0.1,-0.06,~,6,None,true",
    "Vital Sense,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.2,V,4,None,false",
    "Wildfire,"+RIFLE+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_MAG_CAP+",0.15,0.05,V,6,None,false",
    "Depleted Reload,"+RIFLE+",5,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_RELOAD_SPEED+",-0.1,0.08,~,2,None,false",
		"Primed Target Cracker,"+PISTOL+",10,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.1,V,4,None,false",
		"Vigilante Armaments,"+RIFLE+",5,2,"+MOD_TYPE_MULTISHOT+","+MOD_TYPE_VIGILANTE+",0.1,0,~,4,None,false",
		"Vigilante Fervor,"+RIFLE+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_VIGILANTE+",0.075,0,V,4,None,false",
		"Vigilante Armaments,"+SHOTGUN+",5,2,"+MOD_TYPE_MULTISHOT+","+MOD_TYPE_VIGILANTE+",0.1,0,~,4,None,false",
		"Vigilante Fervor,"+SHOTGUN+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_VIGILANTE+",0.075,0,V,4,None,false",
		"Vigilante Supplies,"+RIFLE+",5,1,"+MOD_TYPE_VIGILANTE+",0.0,~,4,None,true",
		"Vigilante Supplies,"+SHOTGUN+",5,1,"+MOD_TYPE_VIGILANTE+",0.0,~,4,None,true",
		"Primed Quickdraw,"+PISTOL+",10,1,"+MOD_TYPE_RELOAD_SPEED+",0.08,~,2,None,false",
		"Primed Slip Magazine,"+PISTOL+",10,1,"+MOD_TYPE_MAG_CAP+",0.05,~,4,None,false",
		"Auger Pact,"+PISTOL+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,2,None,false",
		"Hydraulic Crosshairs,"+PISTOL+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.225,V,2,None,false",
		"Argon Scope,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.225,V,2,None,false",
		"Laser Sight,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.2,V,4,None,false",
		"Bladed Rounds,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.2,V,4,None,false",
		"Shrapnel Shot,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.165,V,4,None,false",
		"Sharpened Bullets,"+PISTOL+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.125,V,2,None,false",
		"Hunter Munitions,"+RIFLE+",5,1,"+MOD_TYPE_MUNITIONS+",0.05,V,4,None,false",
		"Hunter Munitions,"+SHOTGUN+",5,1,"+MOD_TYPE_MUNITIONS+",0.05,V,4,None,false",
		"Primed Shred,"+RIFLE+",10,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_OBJECT_PIERCE+",0.05,0.0,V,6,None,false",
		"Primed Cryo Rounds,"+RIFLE+",10,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
    "Primed Bane of Corpus,"+RIFLE+",10,1,"+MOD_TYPE_CORPUS_DAMAGE+",0.05,V,4,None,false",
    "Primed Bane of Grineer,"+RIFLE+",10,1,"+MOD_TYPE_GRINEER_DAMAGE+",0.05,V,4,None,false",
    "Primed Bane of Corrupted,"+RIFLE+",10,1,"+MOD_TYPE_CORRUPTED_DAMAGE+",0.05,V,4,None,false",
    "Primed Bane of Infested,"+RIFLE+",10,1,"+MOD_TYPE_INFESTED_DAMAGE+",0.05,V,4,None,false",
		"Chilling Reload,"+SHOTGUN+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_RELOAD_SPEED+",0.15,0.1,V,2,None,false",
		"Target Acquired,"+RIFLE+",5,1,"+HEADSHOT_BONUS+",0.1,V,6,None,false",
		"Internal Bleeding,"+RIFLE+",0,1,"+MOD_TYPE_IMPACTSLASH+",0.35,V,0,None,false",
		"Hemorrhage,"+PISTOL+",0,1,"+MOD_TYPE_IMPACTSLASH+",0.35,V,0,None,false",
		//Melee Mods
    "Primed Pressure Point,"+MELEE+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
    "Primed Reach,"+MELEE+",10,1,"+MOD_TYPE_RANGE+",0.15,V,4,None,false",
    "Organ Shatter,"+MELEE+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.15,V,4,None,false",
    "Blood Rush,"+MELEE+",10,1,"+MOD_TYPE_COMBO_CRIT+",0.05454545,V,4,None,false",
    "Weeping Wounds,"+MELEE+",5,1,"+MOD_TYPE_COMBO_STATUS+",0.0667,V,4,None,false",
    "Drifting Contact,"+MELEE+",3,2,"+MOD_TYPE_COMBO_DURATION+","+MOD_TYPE_STATUS_CHANCE+",0.025,0.1,D,2,None,false",
    "Condition Overload,"+MELEE+",5,1,"+MOD_TYPE_CONDITION_OVERLOAD+",0.2,V,10,None,false",
    "Primed Fury,"+MELEE+",10,1,"+MOD_TYPE_FIRE_RATE+",0.05,V,4,None,false",
    "Virulent Scourge,"+MELEE+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Voltaic Strike,"+MELEE+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Volcanic Edge,"+MELEE+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Vicious Frost,"+MELEE+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Berserker,"+MELEE+",5,1,"+MOD_TYPE_MULTI_RATE+",0.125,V,4,None,false",
    "Sacrificial Steel,"+MELEE+",10,1,"+MOD_TYPE_CRIT_CHANCE+",0.1,V,6,None,false",
    "Primed Fever Strike,"+MELEE+",10,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
    "Shattering Imapact,"+MELEE+",5,1,"+MOD_TYPE_SHATTERING_IMPACT+",1,D,4,None,false",
    "Melee Prowess,"+MELEE+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,4,None,false",
    //Arch-Gun Mods
    "Ammo Chain,"+ARCHGUN+",5,1,"+MOD_TYPE_AMMO_CAP+",0.167,~,2,None,false",
    "Arch-Gun Ace,"+ARCHGUN+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_RELOAD_SPEED+",0.08,0.17,V,6,None,false",
    "Automatic Trigger,"+ARCHGUN+",5,1,"+MOD_TYPE_FIRE_RATE+",0.1,V,10,None,false",
    "Charged Bullets,"+ARCHGUN+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Combustion Rounds,"+ARCHGUN+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.2,V,4,None,false",
    "Comet Blast,"+ARCHGUN+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.15,~,2,None,false",
    "Contamination Casing,"+ARCHGUN+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Critical Focus,"+ARCHGUN+",5,2,"+MOD_TYPE_CRIT_CHANCE+","+MOD_TYPE_CRIT_MULTIPLIER+",0.1,0.1,V,6,None,false",
    "Deadly Efficiency,"+ARCHGUN+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.2,V,4,None,false",
    "Dual Rounds,"+ARCHGUN+",5,1,"+MOD_TYPE_MULTISHOT+",0.1,V,6,None,false",
    "Electrified Barrel,"+ARCHGUN+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.2,V,4,None,false",
    "Hollowed Bullets,"+ARCHGUN+",3,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.2,V,4,None,false",
    "Hypothermic Shell,"+ARCHGUN+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Magazine Extension,"+ARCHGUN+",5,1,"+MOD_TYPE_MAG_CAP+",0.1,~,4,None,false",
    "Magma Chamber,"+ARCHGUN+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
    "Marked Target,"+ARCHGUN+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.2,V,6,None,false",
    "Modified Munitions,"+ARCHGUN+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.1,D,4,None,false",
    "Parallax Scope,"+ARCHGUN+",3,1,"+MOD_TYPE_CRIT_CHANCE+",0.25,~,4,None,false",
    "Polar Magazine,"+ARCHGUN+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.2,D,4,None,false",
    "Quasar Drill,"+ARCHGUN+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.15,~,2,None,false",
    "Quick Reload,"+ARCHGUN+",3,1,"+MOD_TYPE_RELOAD_SPEED+",0.25,~,2,None,false",
    "Resolute Focus,"+ARCHGUN+",5,1,"+MOD_TYPE_SPREAD+",-0.08,~,4,None,false",
    "Rubedo-Lined Barrel,"+ARCHGUN+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.167,V,6,None,false",
    "Sabot Rounds,"+ARCHGUN+",5,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_OBJECT_PIERCE+",0.1,0.005,~,10,None,false",
    "Shell Rush,"+ARCHGUN+",3,1,"+MOD_TYPE_FIRE_RATE+",0.125,D,4,None,false",
    "Venomous Clip,"+ARCHGUN+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.2,D,4,None,false",
    "Zodiac Shred,"+ARCHGUN+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.15,~,2,None,false"
    };

public static final String[] maximizerModDB = {
"Accelerated Blast,"+SHOTGUN+",3,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_PUNCTURE_DAMAGE+",0.15,0.15,V,6,None,false",
"Ammo Stock,"+SHOTGUN+",5,1,"+MOD_TYPE_MAG_CAP+",0.1,~,2,None,false",
"Anemic Agility,"+PISTOL+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_DAMAGE_BONUS+",0.15,-0.025,~,4,None,false",
"Argon Scope,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.225,V,2,None,false",
"Auger Pact,"+PISTOL+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,2,None,false",
"Barrel Diffusion,"+PISTOL+",5,1,"+MOD_TYPE_MULTISHOT+",0.2,V,6,None,false",
"Bladed Rounds,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.2,V,4,None,false",
"Blaze,"+SHOTGUN+",3,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_FIRE_DAMAGE+",0.15,0.15,V,6,None,false",
"Blunderbuss,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.15,V,4,None,false",
"Burdened Magazine,"+SHOTGUN+",5,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_RELOAD_SPEED+",0.1,-0.03,~,6,None,false",
"Primed Charged Shell,"+SHOTGUN+",10,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
"Chilling Grasp,"+SHOTGUN+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
"Chilling Reload,"+SHOTGUN+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_RELOAD_SPEED+",0.15,0.1,V,2,None,false",
"Contagious Spread,"+SHOTGUN+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
"Convulsion,"+PISTOL+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
"Deep Freeze,"+PISTOL+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
"Fanged Fusillade,"+RIFLE+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.2,~,6,None,false",
"Frail Momentum,"+SHOTGUN+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_DAMAGE_BONUS+",0.15,-0.025,V,4,None,false",
"Fridgid Blast,"+SHOTGUN+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Frostbite,"+PISTOL+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Gunslinger,"+PISTOL+",5,1,"+MOD_TYPE_FIRE_RATE+",0.12,V,4,None,false",
"Hammer Shot,"+RIFLE+",3,2,"+MOD_TYPE_STATUS_CHANCE+","+MOD_TYPE_CRIT_MULTIPLIER+",0.2,0.15,D,6,None,false",
"Heavy Caliber,"+RIFLE+",10,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_ACCURACY+",0.15,-0.05,V,6,None,false",
"Hell's Chamber,"+SHOTGUN+",5,1,"+MOD_TYPE_MULTISHOT+",0.2,V,10,None,false",
"Hellfire,"+RIFLE+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
"High Voltage,"+RIFLE+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Hornet Strike,"+PISTOL+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.2,V,4,None,false",
"Hunter Munitions,"+RIFLE+",5,1,"+MOD_TYPE_MUNITIONS+",0.05,V,4,None,false",
"Hunter Munitions,"+SHOTGUN+",5,1,"+MOD_TYPE_MUNITIONS+",0.05,V,4,None,false",
"Hydraulic Crosshairs,"+PISTOL+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.225,V,2,None,false",
"Ice Storm,"+PISTOL+",3,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_ICE_DAMAGE+",0.1,0.1,V,6,None,false",
"Incendiary Coat,"+SHOTGUN+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
"Infected Clip,"+RIFLE+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
"Jolt,"+PISTOL+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Laser Sight,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.2,V,4,None,false",
"Lethal Torrent,"+PISTOL+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_MULTISHOT+",0.1,0.1,V,6,None,false",
"Magazine Warp,"+RIFLE+",5,1,"+MOD_TYPE_MAG_CAP+",0.05,~,4,None,false",
"Magnum Force,"+PISTOL+",10,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_ACCURACY+",0.15,-0.05,V,4,None,false",
"Maim,"+PISTOL+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.2,~,6,None,false",
"Malignant Force,"+RIFLE+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Pathogen Rounds,"+PISTOL+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
"Pistol Pestilence,"+PISTOL+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Point Strike,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_CHANCE+",0.25,V,4,None,false",
"Primed Cryo Rounds,"+RIFLE+",10,1,"+MOD_TYPE_ICE_DAMAGE+",0.15,D,6,None,false",
"Primed Fast Hands,"+RIFLE+",10,1,"+MOD_TYPE_RELOAD_SPEED+",0.05,~,2,None,false",
"Primed Heated Charge,"+PISTOL+",10,1,"+MOD_TYPE_FIRE_DAMAGE+",0.15,~,6,None,false",
"Primed Pistol Gambit,"+PISTOL+",10,1,"+MOD_TYPE_CRIT_CHANCE+",0.17,V,2,None,false",
"Primed Point Blank,"+SHOTGUN+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
"Primed Quickdraw,"+PISTOL+",10,1,"+MOD_TYPE_RELOAD_SPEED+",0.08,~,2,None,false",
"Primed Ravage,"+SHOTGUN+",10,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.1,V,4,None,false",
"Primed Shred,"+RIFLE+",10,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_OBJECT_PIERCE+",0.05,0.0,V,6,None,false",
"Primed Slip Magazine,"+PISTOL+",10,1,"+MOD_TYPE_MAG_CAP+",0.05,~,4,None,false",
"Primed Target Cracker,"+PISTOL+",10,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.1,V,4,None,false",
"Rime Rounds,"+RIFLE+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Scattering Inferno,"+SHOTGUN+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Scorch,"+PISTOL+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Seeking Fury,"+SHOTGUN+",5,2,"+MOD_TYPE_OBJECT_PIERCE+","+MOD_TYPE_RELOAD_SPEED+",0.002,0.025,V,6,None,false",
"Serration,"+RIFLE+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
"Sharpened Bullets,"+PISTOL+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.125,V,2,None,false",
"Shell Shock,"+SHOTGUN+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Shotgun Spazz,"+SHOTGUN+",5,1,"+MOD_TYPE_FIRE_RATE+",0.15,V,4,None,false",
"Shrapnel Shot,"+SHOTGUN+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.165,V,4,None,false",
"Speed Trigger,"+RIFLE+",5,1,"+MOD_TYPE_FIRE_RATE+",0.1,V,4,None,false",
"Split Chamber,"+RIFLE+",5,1,"+MOD_TYPE_MULTISHOT+",0.15,V,10,None,false",
"Stormbringer,"+RIFLE+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.15,~,6,None,false",
"Sweeping Serration,"+SHOTGUN+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.2,~,6,None,false",
"Tactical Pump,"+SHOTGUN+",5,1,"+MOD_TYPE_RELOAD_SPEED+",0.05,~,2,None,false",
"Tainted Mag,"+RIFLE+",10,2,"+MOD_TYPE_MAG_CAP+","+MOD_TYPE_RELOAD_SPEED+",0.06,-0.03,~,4,None,false",
"Thermite Rounds,"+RIFLE+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Toxic Barrage,"+SHOTGUN+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Vicious Spread,"+SHOTGUN+",5,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_SPREAD+",0.15,0.1,V,4,None,false",
"Vigilante Armaments,"+RIFLE+",5,2,"+MOD_TYPE_MULTISHOT+","+MOD_TYPE_VIGILANTE+",0.1,0,~,4,None,false",
"Vigilante Armaments,"+SHOTGUN+",5,2,"+MOD_TYPE_MULTISHOT+","+MOD_TYPE_VIGILANTE+",0.1,0,~,4,None,false",
"Vile Acceleration,"+RIFLE+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_DAMAGE_BONUS+",0.15,-0.025,V,4,None,false",
"Vital Sense,"+RIFLE+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.2,V,4,None,false",
"Wildfire,"+RIFLE+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_MAG_CAP+",0.15,0.05,V,6,None,false",
"Rifle Aptitude,"+RIFLE+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,4,None,false",
"Sure Shot,"+PISTOL+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,2,None,false",
"Shotgun Savvy,"+SHOTGUN+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,4,None,false",
//Melee Mods
"Primed Pressure Point,"+MELEE+",10,1,"+MOD_TYPE_DAMAGE_BONUS+",0.15,V,4,None,false",
"Primed Reach,"+MELEE+",10,1,Range,0.15,V,4,None,false",
"Organ Shatter,"+MELEE+",5,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.15,V,4,None,false",
"Blood Rush,"+MELEE+",10,1,"+MOD_TYPE_COMBO_CRIT+",0.05454545,V,4,None,false",
"Weeping Wounds,"+MELEE+",5,1,"+MOD_TYPE_COMBO_STATUS+",0.0667,V,4,None,false",
"Drifting Contact,"+MELEE+",3,2,"+MOD_TYPE_COMBO_DURATION+","+MOD_TYPE_STATUS_CHANCE+",0.025,0.1,D,2,None,false",
"Condition Overload,"+MELEE+",5,1,"+MOD_TYPE_DAMAGE_BONUS+"PerStatus,0.2,V,10,None,false",
"Primed Fury,"+MELEE+",10,1,"+MOD_TYPE_FIRE_RATE+",0.05,V,4,None,false",
"Virulent Scourge,"+MELEE+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Voltaic Strike,"+MELEE+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Volcanic Edge,"+MELEE+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Vicious Frost,"+MELEE+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Berserker,"+MELEE+",5,1,"+MOD_TYPE_FIRE_RATE+"(Multiplicative),0.125,V,4,None,false",
"Sacrificial Steel,"+MELEE+",10,1,"+MOD_TYPE_CRIT_CHANCE+",0.1,V,6,None,false",
"Primed Fever Strike,"+MELEE+",10,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.15,~,6,None,false",
"Shattering Imapact,"+MELEE+",5,1,"+MOD_TYPE_SHATTERING_IMPACT+",1,D,4,None,false",
"Melee Prowess,"+MELEE+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.15,D,4,None,false",
//Arch-Gun Mods
"Ammo Chain,"+ARCHGUN+",5,1,"+MOD_TYPE_AMMO_CAP+",0.167,~,2,None,false",
"Arch-Gun Ace,"+ARCHGUN+",5,2,"+MOD_TYPE_FIRE_RATE+","+MOD_TYPE_RELOAD_SPEED+",0.08,0.17,V,6,None,false",
"Automatic Trigger,"+ARCHGUN+",5,1,"+MOD_TYPE_FIRE_RATE+",0.1,V,10,None,false",
"Charged Bullets,"+ARCHGUN+",3,2,"+MOD_TYPE_LIGHTNING_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Combustion Rounds,"+ARCHGUN+",5,1,"+MOD_TYPE_FIRE_DAMAGE+",0.2,V,4,None,false",
"Comet Blast,"+ARCHGUN+",5,1,"+MOD_TYPE_IMPACT_DAMAGE+",0.15,~,2,None,false",
"Contamination Casing,"+ARCHGUN+",3,2,"+MOD_TYPE_TOXIN_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Critical Focus,"+ARCHGUN+",5,2,"+MOD_TYPE_CRIT_CHANCE+","+MOD_TYPE_CRIT_MULTIPLIER+",0.1,0.1,V,6,None,false",
"Deadly Efficiency,"+ARCHGUN+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.2,V,4,None,false",
"Dual Rounds,"+ARCHGUN+",5,1,"+MOD_TYPE_MULTISHOT+",0.1,V,6,None,false",
"Electrified Barrel,"+ARCHGUN+",5,1,"+MOD_TYPE_LIGHTNING_DAMAGE+",0.2,V,4,None,false",
"Hollowed Bullets,"+ARCHGUN+",3,1,"+MOD_TYPE_CRIT_MULTIPLIER+",0.2,V,4,None,false",
"Hypothermic Shell,"+ARCHGUN+",3,2,"+MOD_TYPE_ICE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Magazine Extension,"+ARCHGUN+",5,1,"+MOD_TYPE_MAG_CAP+",0.1,~,4,None,false",
"Magma Chamber,"+ARCHGUN+",3,2,"+MOD_TYPE_FIRE_DAMAGE+","+MOD_TYPE_STATUS_CHANCE+",0.15,0.15,V,4,None,false",
"Marked Target,"+ARCHGUN+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.2,V,6,None,false",
"Modified Munitions,"+ARCHGUN+",5,1,"+MOD_TYPE_STATUS_CHANCE+",0.1,D,4,None,false",
"Parallax Scope,"+ARCHGUN+",3,1,"+MOD_TYPE_CRIT_CHANCE+",0.25,~,4,None,false",
"Polar Magazine,"+ARCHGUN+",5,1,"+MOD_TYPE_ICE_DAMAGE+",0.2,D,4,None,false",
"Quasar Drill,"+ARCHGUN+",5,1,"+MOD_TYPE_PUNCTURE_DAMAGE+",0.15,~,2,None,false",
"Quick Reload,"+ARCHGUN+",3,1,"+MOD_TYPE_RELOAD_SPEED+",0.25,~,2,None,false",
"Resolute Focus,"+ARCHGUN+",5,1,"+MOD_TYPE_SPREAD+",-0.08,~,4,None,false",
"Rubedo-Lined Barrel,"+ARCHGUN+",5,1,"+MOD_TYPE_DAMAGE_BONUS+",0.167,V,6,None,false",
"Sabot Rounds,"+ARCHGUN+",5,2,"+MOD_TYPE_DAMAGE_BONUS+","+MOD_TYPE_OBJECT_PIERCE+",0.1,0.005,~,10,None,false",
"Shell Rush,"+ARCHGUN+",3,1,"+MOD_TYPE_FIRE_RATE+",0.125,D,4,None,false",
"Venomous Clip,"+ARCHGUN+",5,1,"+MOD_TYPE_TOXIN_DAMAGE+",0.2,D,4,None,false",
"Zodiac Shred,"+ARCHGUN+",5,1,"+MOD_TYPE_SLASH_DAMAGE+",0.15,~,2,None,false"
};

/** Default Weapons for use if the file is missing **/
public static final String[] baseWeapons = {PISTOL+","+SEMI_AUTO+","+TOXIN_WEAPON_DAMAGE+",Acrid,0.0,0,DEPRECIATED,35,0.0,0.0,0.0,6.67,15,210,1.2,5,2,10,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Afuris,0.0,0,DEPRECIATED,0.0,3,14,3,12.5,70,210,2,5,2,12,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",AkJagara,0.0,2,DEPRECIATED,0.0,4.5,4.5,21,8.33,36,210,2.25,6,2,28,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",AkJagara Prime,0.0,2,DEPRECIATED,0.0,3.6,3.6,28.8,10,40,1,1.4,18,2.2,32,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",AkZani,0.0,0,DEPRECIATED,0.0,1.8,8.4,1.8,20,100,400,2,14,2,14,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akbolto,0.0,0,DEPRECIATED,0.0,4,36,0,10,30,210,2.6,16,2.4,2.2,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akbolto Prime,0.0,0,DEPRECIATED,0.0,3.2,27.5,1.3,7,40,210,1.3,36,2.8,14,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akbronco,0.0,0,Blade and Whip,0.0,224,28,28,8.33,4,210,2.25,6,2,3.1,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akbronco Prime,0.0,0,Blade and Whip,0.0,280,35,35,4.33,8,210,2.25,6,2,12.9,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Aklato,0.0,0,DEPRECIATED,0.0,4.5,7.5,18,7.5,30,210,2.4,10,1.8,6,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Aklex,0.0,0,DEPRECIATED,0.0,13,104,13,1.58,12,210,3,20,2,10,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Aklex Prime,0.0,0,DEPRECIATED,0.0,15,120,15,2.67,16,210,3,25,2,25,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akmagnus,0.0,0,DEPRECIATED,0.0,34.2,20.9,20.9,6.17,16,210,2.4,22,2,22,1,1",
PISTOL+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Aksomati,0.0,0,DEPRECIATED,0.0,1.8,7.2,9,12.5,70,210,1.4,24,3,8,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akstiletto,0.0,0,DEPRECIATED,0.0,16.8,2.8,8.4,10,28,210,1.1,18,1.8,18,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akstiletto Prime,0.0,0,DEPRECIATED,0.0,21.6,3.6,10.8,7.08,40,400,1.1,15,2,30,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akvasto,0,0,DEPRECIATED,0,14.5,14.5,29,8.67,12,210,2,16,1.8,12,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Akvasto Prime,0,0,DEPRECIATED,0,9.9,9.9,46.2,6.33,12,1,1.4,22,2.4,22,1,1",
RIFLE+","+CONTINUOUS+","+ELECTRIC_WEAPON_DAMAGE+",Amprex,0.0,0,DEPRECIATED,22,0.0,0.0,0.0,12.5,100,700,2.6,32,2.2,22,1,0.5",
PISTOL+","+CHARGE+","+BLAST_WEAPON_DAMAGE+",Angstrum (Charged),1.5,0,Blade and Whip,750,0.0,0.0,0.0,2,1,6,2.5,16,2,22,3,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Angstrum (Single Rocket),0.0,0,DEPRECIATED,250,0.0,0.0,0.0,2,3,18,2.5,16,2,22,1,1",
SHOTGUN+","+SEMI_AUTO+","+RADIATION_WEAPON_DAMAGE+",Arca Plasmor,0,0,DEPRECIATED,600,0,0,0,1.1,10,48,2.8,22,1.6,28,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Arca Scisco,0,0,DEPRECIATED,0,0,36,24,4.67,36,288,2.2,18,1.6,26,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Argonak (Full-auto),0.0,0,DEPRECIATED,0.0,24.5,6.3,26.2,6,43,540,2.4,9,1.5,27,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Argonak (Semi-auto),0.0,0,DEPRECIATED,0.0,24.5,6.3,26.2,4.33,43,473,2.4,27,2.3,19,1,1",
PISTOL+","+CONTINUOUS+","+FIRE_WEAPON_DAMAGE+",Atomos,0,0,DEPRECIATED,29,0,0,0,8,70,300,2,15,1.7,21,1,1",
RIFLE+","+AUTOBOW+","+PHYSICAL_WEAPON_DAMAGE+",Attica,0,0,DEPRECIATED,0,4,60,16,3.67,20,540,2.8,25,3,10,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Azima,0,0,DEPRECIATED,0,2,5,13,10,75,525,1.4,16,2,16,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Ballistica (Burst),1,4,DEPRECIATED,0,2.5,20,2.5,11.43,16,210,2,3.75,1.5,2.5,1,1",
PISTOL+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Ballistica (Charge),1,4,DEPRECIATED,0,10,80,10,3.33,16,210,2,15,1.5,10,1,1",
PISTOL+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Ballistica Prime (Charge),0.8,0,Blade and Whip,0,15,167.2,121.6,3.33,8,210,1.2,20,2,5,4,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Ballistica Prime (Normal),0,0,Blade and Whip,0,7.6,83.6,60.8,3.33,8,210,1.2,20,2,5,4,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Baza,0.0,0,DEPRECIATED,0.0,5.8,6.7,3.5,16.67,40,800,1.4,26,3,10,1,1",
SHOTGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Boar,0.0,0,Blade and Whip,0.0,96.8,26.4,52.8,5,20,120,2.7,10,1.5,7.5,8,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
SHOTGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Boar Prime,0.0,0,DEPRECIATED,0.0,208,48,64,4.67,20,120,2.75,15,2,30,8,1,null,null,null,null,null,null,null,null,No Element,null,No Element,No Element,null",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Bolto,0,0,DEPRECIATED,0,4,36,0,6.83,15,210,1.3,16,2.4,2.2,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Boltor,0.0,0,DEPRECIATED,0.0,2.5,20.0,2.5,8.75,60,540,2.6,10,1.8,14,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Boltor Prime,0.0,0,DEPRECIATED,0.0,4.6,41.4,0,10,60,540,2.4,12,2,34,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Brakk,0,0,Blade and Whip,0,90,50,60,5,5,210,1.05,17,2,5.1,10,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Braton,0.0,0,DEPRECIATED,0.0,7.9,7.9,8.2,8.75,45,540,2,12,1.6,6,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Braton Prime,0.0,0,DEPRECIATED,0.0,1.75,12.25,21,9.58,75,540,2.15,12,2,26,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Braton Vandal,0.0,0,DEPRECIATED,0.0,12.25,1.75,21,7.5,50,540,1.75,16,2,10,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Bronco,0,0,Blade and Whip,0,224,28,28,5,2,210,1.05,6,2,9.4,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Bronco Prime,0,0,Blade and Whip,0,280,35,35,4.17,4,210,2,6,2,12.9,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Burston,0.0,3,DEPRECIATED,0.0,10,10,10,7.83,45,540,2,6,1.6,18,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Burston Prime,0.0,3,DEPRECIATED,0.0,10.8,10.8,14.4,13.64,45,540,2,18,1.8,30,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Buzlok,0.0,0,DEPRECIATED,0.0,30,24,6,6.25,50,540,3,23,2.5,21,1,1",
PISTOL+","+SEMI_AUTO+","+ELECTRIC_WEAPON_DAMAGE+",Castanas,0.0,0,DEPRECIATED,160,0,0,0,3.33,2,18,1,8,1.5,22,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Cernos (Uncharged),0.5,0,DEPRECIATED,0,198,11,11,1,1,72,0.6,36,2,18,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Cernos,1,3,6.7,300,180,10,10,0,1,72,0.6,35,2,10,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Cernos Prime,0.5,0,DEPRECIATED,0,324,18,18,0,1,72,0.65,35,2,30,3,1",
PISTOL+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Cestra,0,0,DEPRECIATED,0,5.2,20.8,0,8.33,60,420,2,6,1.6,20,1,1",
SHOTGUN+","+CONTINUOUS+","+PHYSICAL_WEAPON_DAMAGE+",Convectrix,0.0,0,Blade and Whip,0.0,2.4,2.4,19.2,12,70,700,2,16,2.4,45,2,0.5,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
SHOTGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Corinth,0.0,0,Blade and Whip,0.0,151.2,226.8,162,1.17,5,132,2.3,30,2.8,6,6,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Daikyu,1,0,DEPRECIATED,0,138,184,138,0,1,72,0.6,20,2,50,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dera,0.0,0,DEPRECIATED,0.0,6,22.5,1.5,11.25,45,540,1.8,8,1.6,22,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dera Vandal,0.0,0,DEPRECIATED,0.0,6.4,24,1.6,11.25,60,540,1.8,8,2,30,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Despair,0.0,0,DEPRECIATED,0,2.9,46.4,8.7,3.33,10,210,0.75,16,1.6,16,1,1",
PISTOL+","+SEMI_AUTO+","+RADIATION_WEAPON_DAMAGE+",Detron,0,0,Blade and Whip,280,0,0,0,3.33,5,210,1.05,4,1.5,12.9,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dex Furis,0.0,0,DEPRECIATED,0.0,2.4,11.2,2.4,20,100,400,2,14,2,28,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Dex Sybaris,0.0,2,DEPRECIATED,0,22.5,18.75,33.75,4.17,14,540,1.5,35,2,10,1,1",
SHOTGUN+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Drakgoon,0.5,0,Blade and Whip,0.0,70,70,560,3.33,7,120,2.3,7.5,2,6.9,10,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dread (Uncharged),0.5,0,DEPRECIATED,0,10,10,180,1,1,72,0.7,50,2,20,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Dread,0.5,3,6.7,300,10,10,180,0,1,72,0.7,50,2,20,1,1",
PISTOL+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Dual Cestra,0.0,0,DEPRECIATED,0.0,5.2,20.8,0,12.5,120,210,3.5,6,1.6,20,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dual Toxocyst,0.0,0,DEPRECIATED,0.0,7.5,60,7.5,1,12,72,2.35,5,2,37,1,1",
PISTOL+","+CONTINUOUS+","+TOXIN_WEAPON_DAMAGE+",Embolist,0,0,DEPRECIATED,35,0,0,0,8,33,210,1.3,3,1.5,41,1,0.5",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Euphona Prime (Slug),0.0,0,DEPRECIATED,0.0,292.5,16.25,16.25,1.5,5,210,2,30,2.5,2,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Euphona Prime (Buckshot),0.0,0,Blade and Whip,0.0,44,176,660,1.5,5,210,2,2,2,9,10,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Ferrox,0.5,0,DEPRECIATED,0.0,35,245,70,1.33,10,540,2,32,2.8,10,1,1",
RIFLE+","+CONTINUOUS+","+PHYSICAL_WEAPON_DAMAGE+",Flux Rifle,0.0,0,DEPRECIATED,25,0,4.8,17.2,12,50,9999,2.25,10,2,24,1,0.5",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Furis,0,0,DEPRECIATED,0,3,14,3,10,35,210,1.4,5,2,12,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Fusilai (Full-Auto),0.0,0,DEPRECIATED,77,0,30.8,46.2,2.83,6,72,0.8,23,1.7,29,1,1",
PISTOL+","+CONTINUOUS+","+MAGNETIC_WEAPON_DAMAGE+",Gammacor,0,0,DEPRECIATED,16,0,0,0,12,60,210,1.4,8,1.8,20,1,0.5",
RIFLE+","+CONTINUOUS+","+ICE_WEAPON_DAMAGE+",Glaxion,0,0,DEPRECIATED,26,0,0,0,12,80,720,2.2,8,2,34,1,0.5",
RIFLE+","+CONTINUOUS+","+ICE_WEAPON_DAMAGE+",Glaxion Vandal,0,0,DEPRECIATED,29,0,0,0,12,100,720,1.8,14,2,38,1,0.5",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Gorgon,0.0,0,DEPRECIATED,0.0,18.75,3.75,2.5,12.5,90,540,4.2,17,1.5,9,1,1",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Gorgon Wraith,0.0,0,DEPRECIATED,0.0,23,2.7,1.3,13.3,90,540,3,15,1.9,21,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Grakata,0.0,0,DEPRECIATED,0.0,4.4,3.7,2.9,20,60,750,2.4,25,2,20,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Grinlok,0.0,0,DEPRECIATED,0.0,93.5,18.7,74.8,1.67,9,540,1.7,15,2.5,35,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Harpak,0,3,DEPRECIATED,0,5,37.5,7.5,6,45,540,2,20,2.3,17,1,1",
SHOTGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Hek,0.0,0,Blade and Whip,0.0,78.75,341.25,105,2.17,4,120,2,10,2,10.7,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+BURST+","+VIRAL_WEAPON_DAMAGE+",Hema,0.0,3,DEPRECIATED,47,0,0,0,6,60,999,2,11,2,25,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Hikou,0.0,0,DEPRECIATED,0,2.6,15.6,7.8,6.67,20,210,0.75,4,1.6,10,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Hikou Prime,0.0,0,DEPRECIATED,0,3.6,30.6,1.8,5.83,26,210,0.5,6,1.8,15,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Hind (Burst),0.0,5,DEPRECIATED,0.0,7.5,7.5,15,6.25,65,540,2,7,1.5,15,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Hind (Semi-Auto),0.0,0,DEPRECIATED,0.0,12,12,36,2.5,65,540,2,15,2,10,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Hystrix (Poison),0,0,DEPRECIATED,0,2.2,31,2.9,7,16,210,1.7,24,2.2,10,1,1",
RIFLE+","+CONTINUOUS+","+FIRE_WEAPON_DAMAGE+",Ignis,0.0,0,DEPRECIATED,33,0,0,0,8,150,750,2,11,2,27,1,1",
RIFLE+","+CONTINUOUS+","+FIRE_WEAPON_DAMAGE+",Ignis Wraith,0.0,0,DEPRECIATED,35,0,0,0,8,200,800,1.7,17,2.5,29,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Karak,0.0,0,DEPRECIATED,0.0,13,8.7,7.3,11.67,30,540,2,9,1.5,15,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Karak Wraith,0.0,0,DEPRECIATED,0.0,14.1,9.3,7.8,11.67,60,540,2,13,2,25,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Knell,0.0,0,DEPRECIATED,150,63,69,18,4,9999,9999,1,20,1.5,5,1,1",
SHOTGUN+","+FULL_AUTO_BULLET_RAMP+","+PHYSICAL_WEAPON_DAMAGE+",Kohm,0.0,0,Blade and Whip,0.0,72,72,216,3.67,245,960,2,11,2.3,75,12,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO_BULLET_RAMP+","+PHYSICAL_WEAPON_DAMAGE+",Kohmak,0.0,0,Blade and Whip,0.0,30,30,90,5,40,210,2,11,2,69,5,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Kraken,0,2,DEPRECIATED,0,36.8,6.1,6.1,4.42,14,210,2.45,5,2,13,1,1",
PISTOL+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Kulstar (With Bombs),0,0,DEPRECIATED,525,0,0,0,2,3,15,2,17,2.3,19,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Kunai,0.0,0,DEPRECIATED,0,4.6,34.5,6.9,3.33,10,210,0.8,8,1.6,8,1,1",
RIFLE+","+LANKA+","+ELECTRIC_WEAPON_DAMAGE+",Lanka,1,0,DEPRECIATED,525,0,0,0,1,10,2,2,25,2,25,1,1,Scoped CC,20,30,50",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Lato,0,0,DEPRECIATED,0,7.5,7.5,15,6.67,15,210,1,10,1.8,6,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Lato Prime,0.0,0,DEPRECIATED,0.0,4.8,9.6,33.6,6.67,20,210,1,30,2,20,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Lato Vandal,0.0,0,DEPRECIATED,0.0,6.9,11.5,27.6,5,15,210,1,26,2.4,10,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Latron,0.0,0,DEPRECIATED,0.0,8.25,38.5,8.25,4.17,15,540,2.4,12,2,12,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Latron Prime,0.0,5,DEPRECIATED,0.0,9,72,9,4.2,15,540,2.4,22,2.8,26,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Latron Wraith,0.0,0,DEPRECIATED,0.0,15,42,3,5.42,15,540,2.4,26,2.8,14,1,1",
RIFLE+","+CHARGEBOW+","+BLAST_WEAPON_DAMAGE+",Lenz,1.2,0,DEPRECIATED,660,0,0,0,1,1,6,0.6,50,2,5,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Lex,0,0,DEPRECIATED,0,13,104,13,1.08,6,210,2.35,20,2,10,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Lex Prime,0.0,0,DEPRECIATED,0.0,15,120,15,2.08,8,210,2.35,25,2,25,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",MK-1 Furis,1,4,DEPRECIATED,0,1.95,9.1,1.95,8.33,35,210,1.4,5,2,1,1,1",
SHOTGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",MK-1 Strun,0.0,0,Blade and Whip,0.0,99,27,54,2.08,6,120,3.75,7.5,1.5,6,10,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",MK1-Braton,0.0,0,DEPRECIATED,0.0,4.5,4.5,9,7.5,60,540,2.0,8,1.5,5,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",MK1-Kunai,0.0,0,DEPRECIATED,0,4,30,6,3.33,10,210,0.75,5,2,2.5,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",MK1-Paris,0.5,0,DEPRECIATED,0,6,96,18,0,1,72,0.55,30,2,15,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Magnus,1,2,DEPRECIATED,0,34.2,20.9,20.9,5.83,8,210,1.4,22,2,22,1,1",
PISTOL+","+SEMI_AUTO+","+RADIATION_WEAPON_DAMAGE+",Mara Detron,0,0,Blade and Whip,280,0,0,0,3.33,8,210,1.05,8,1.5,13.7,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Marelok,0,0,DEPRECIATED,0,80,16,64,2,6,210,1.67,15,1.5,30,1,1",
RIFLE+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Miter,0.75,0,DEPRECIATED,0,12.5,12.5,225,2.5,20,72,2,10,2,50,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Mutalist Cernos,0.5,0,DEPRECIATED,0,202.5,11.25,11.25,0,1,72,0.6,15,2,49,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Mutalist Quanta,0.0,0,DEPRECIATED,0.0,2.5,15,7.5,10,60,540,3,2.5,1.5,15,1,1",
RIFLE+","+SEMI_AUTO+","+RADIATION_WEAPON_DAMAGE+",Mutalist Quanta Cubes,2.5,5,14,200,0,0,0,1,4,31,2,15,2,15,1,1",
PISTOL+","+CONTINUOUS+","+RADIATION_WEAPON_DAMAGE+",Nukor,0,0,DEPRECIATED,22,0,0,0,10,50,210,2,3,4,29,1,0.5",
RIFLE+","+CHARGE+","+BLAST_WEAPON_DAMAGE+",Ogris,0.3,0,DEPRECIATED,600,0,0,0,1.5,5,20,2.5,5,2,35,1,1",
RIFLE+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Opticor,2,0,DEPRECIATED,0.0,100,850,50,1,5,200,2,20,2.5,20,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Pandero,0.0,0,DEPRECIATED,72,18,18,36,3,8,210,1,30,2.8,10,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Panthera,0,0,DEPRECIATED,0,20,10,70,3,60,540,2,12,2,24,1,1",
RIFLE+","+CONTINUOUS+","+PHYSICAL_WEAPON_DAMAGE+",Panthera (Secondary),0,0,DEPRECIATED,0,10,10,80,2,60,540,2,25,2,35,1,1",
RIFLE+","+BURST+","+TOXIN_WEAPON_DAMAGE+",Paracyst,0.0,3,DEPRECIATED,33,0,0,0,11.11,60,540,2,10,2,30,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Paris,0.5,0,DEPRECIATED,0,9,144,27,0,1,72,0.65,30,2,10,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Paris Prime,0.5,0,DEPRECIATED,0,6.5,208,45.5,0,1,72,0.7,45,2,20,1,1",
RIFLE+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Penta,0,0,DEPRECIATED,350,0,0,0,1,5,20,2.5,10,2,10,1,1",
SHOTGUN+","+CONTINUOUS+","+VIRAL_WEAPON_DAMAGE+",Phage,0,0,Blade and Whip,35,0,0,0,12,90,720,2,19,2,15.5,7,0.5,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO+","+TOXIN_WEAPON_DAMAGE+",Pox (Poison Cloud),0.0,0,DEPRECIATED,100,0,0,0,2.08,4,20,1,1,2,35,1,1",
PISTOL+","+CHARGE+","+BLAST_WEAPON_DAMAGE+",Prisma Angstrum (Charged),0.6,0,Blade and Whip,750,0.0,0.0,0.0,2,1,6,1.8,18,2.2,26,3,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Prisma Angstrum (Uncharged),0.0,0,DEPRECIATED,250,0.0,0.0,0.0,2,3,18,2,18,2.2,26,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Prisma Twin Gremlins,0.0,0,DEPRECIATED,0.0,3,12.7,11.3,8.83,70,600,0.9,23,1.9,23,1,1",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Prisma Gorgon,0.0,0,DEPRECIATED,0.0,17.3,3.5,2.3,14.17,120,840,3,30,2.3,15,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Prisma Grakata,0.0,0,DEPRECIATED,0.0,6,5,4,21.67,120,1000,2,25,2.5,21,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Prisma Tetra,0.0,0,DEPRECIATED,0,7.6,30.4,0,7.08,60,540,2,10,2,24,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Pyrana,0.0,0,Blade and Whip,0.0,26.4,26.4,211.2,4.17,10,210,2,20,2,2.5,12,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Pyrana Prime,0.0,0,Blade and Whip,0.0,19.2,19.2,201.6,6.1,12,210,1.6,24,2.4,3.6,12,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+CONTINUOUS+","+ELECTRIC_WEAPON_DAMAGE+",Quanta,0.0,0,DEPRECIATED,20,0,0,0,12,60,540,2,16,2.2,16,1,0.5",
RIFLE+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Quanta (Cubes),0.0,0,DEPRECIATED,250,0,0,0,12,6,540,2,16,2.2,16,1,1",
RIFLE+","+CONTINUOUS+","+ELECTRIC_WEAPON_DAMAGE+",Quanta Vandal,0.0,0,DEPRECIATED,26,0,0,0,12,80,560,1.8,22,2.4,30,1,0.5",
RIFLE+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Quanta Vandal (Cubes),0.0,0,DEPRECIATED,250,0,0,0,4,8,56,1.8,5,1.5,26,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Quartakk,0.0,4,DEPRECIATED,0.0,18.1,14.2,16.7,6.33,84,540,1.9,19,2.3,27,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Rakta Ballistica (Burst),1,4,DEPRECIATED,0,3.75,67.5,3.75,11.43,20,210,2,5,1.5,2.5,1,1",
PISTOL+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Rakta Ballistica (Charge),1,4,DEPRECIATED,0,15,270,15,3.33,20,210,2,20,1.5,10,1,1",
RIFLE+","+CHARGEBOW+","+PHYSICAL_WEAPON_DAMAGE+",Rakta Cernos,0.25,0,DEPRECIATED,0,225,12.5,12.5,0,1,72,0.6,35,2,15,1,1",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Rubico,0,0,DEPRECIATED,0,144,27,9,2.67,5,1,2.4,30,3,12,1,1,Scoped CD,35,50",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Rubico Prime,0,0,DEPRECIATED,0,149.6,28.1,9.3,3.67,5,1,2,38,3,16,1,1,Scoped CD,35,50",
PISTOL+","+SEMI_AUTO+","+ELECTRIC_WEAPON_DAMAGE+",Sancti Castanas,0.0,0,DEPRECIATED,300,0,0,0,3.33,2,18,1,24,2,34,1,1",
SHOTGUN+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Sancti Tigris,0.0,2,Blade and Whip,0.0,126,126,1008,2,2,120,1.5,15,1.5,14,6,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Secura Dual Cestra,0.0,0,DEPRECIATED,0.0,5.6,22.4,0,12.5,120,480,3.5,16,1.6,28,1,1",
RIFLE+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Secura Penta,0,0,DEPRECIATED,300,0,0,0,2,7,28,2.5,26,2,26,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Seer,0,0,DEPRECIATED,0,33.67,33.67,33.67,2,8,210,2.8,5,1.5,13,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Sicarus,1,3,DEPRECIATED,0,21,4.5,4.5,7.39,15,210,2,16,2,6,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Sicarus Prime,1,3,DEPRECIATED,50,20,15,15,9.38,24,210,2,25,2,20,1,1",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Snipetron,0,0,DEPRECIATED,300,18,144,18,2,4,3,3.5,30,1.5,12,1,1,Headshot Dmg,30,50",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Snipetron Vandal,0,0,DEPRECIATED,0,10,180,10,2,6,3,2,28,2,16,1,1,Headshot Dmg,30,50",
SHOTGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Sobek,0.0,0,Blade and Whip,0.0,262.5,43.75,43.75,2.5,20,240,2.7,11,2,16.2,5,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Soma,0.0,0,DEPRECIATED,0,1.2,4.8,6,15,100,540,3,30,3,7,1,1",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Soma Prime,0.0,0,DEPRECIATED,0.0,1.2,4.8,6,15,200,800,3,30,3,10,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Sonicor,0,0,DEPRECIATED,0,200,0,0,1.25,15,150,3,10,2,25,1,1",
PISTOL+","+CONTINUOUS+","+PHYSICAL_WEAPON_DAMAGE+",Spectra,0,0,DEPRECIATED,0,0,7.6,10.4,12,60,360,1.8,14,2,22,1,0.5",
PISTOL+","+CONTINUOUS+","+PHYSICAL_WEAPON_DAMAGE+",Spectra Vandal,0,0,DEPRECIATED,0,0,9.2,12.8,12,80,360,1.2,20,2,28,1,0.5",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Spira,0.0,0,DEPRECIATED,0,8.2,49.2,24.6,2.5,10,210,1,30,2,8,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Spira Prime,0.0,0,DEPRECIATED,0,6,48,6,3.33,12,210,0.75,30,3,14,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Stradavar (Full-Auto),0.0,0,DEPRECIATED,0.0,9.8,9.8,8.4,10,65,540,2,24,2,12,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Stradavar (Semi-Auto),0.0,0,DEPRECIATED,0.0,7.5,30,12.5,5,65,540,2,28,2,16,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Stradavar Prime (Auto),0.0,0,DEPRECIATED,0.0,10.5,10.5,9.0,10,90,1,2,24,2.6,12,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Stradavar Prime (Semi),0.0,0,DEPRECIATED,0.0,8,24,48,3.33,90,1,2,30,2.8,22,1,1",
PISTOL+","+SEMI_AUTO+","+RADIATION_WEAPON_DAMAGE+",Staticor (Uncharged),0,0,DEPRECIATED,132,0,0,0,3.5,45,270,1.5,28,2.2,28,1,1",
SHOTGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Strun,0.0,0,Blade and Whip,0.0,165,45,90,2.5,6,120,3.75,7.5,1.5,5,12,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
SHOTGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Strun Wraith,0.0,0,Blade and Whip,0.0,260,60,80,2.5,10,120,5,18,2.2,12,10,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Stubba,0,0,DEPRECIATED,0,14.2,3.3,15.5,6.33,57,399,1.3,23,1.9,13,1,1",
PISTOL+","+SEMI_AUTO+","+CORROSIVE_WEAPON_DAMAGE+",Stug,1,0,DEPRECIATED,156,0,0,0,4,20,210,2,5,1.5,0,1,1",
PISTOL+","+CHARGE+","+CORROSIVE_WEAPON_DAMAGE+",Stug (Charge),3,0,DEPRECIATED,936,0,0,0,4,3,210,2,5,1.5,0,1,1",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Supra,0,0,DEPRECIATED,0,4,30,6,12.5,180,1080,3,12,1.8,30,1,1",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Supra Vandal,0,0,DEPRECIATED,0,4,30,6,12.5,300,1600,3,16,2,30,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Sybaris,0.0,2,DEPRECIATED,0,26.4,26.4,27.2,3.98,10,540,2,25,2,10,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Sybaris Prime,0.0,2,DEPRECIATED,0,29,29,29.9,4.72,20,540,2,30,2,25,1,1",
RIFLE+","+CONTINUOUS+","+CORROSIVE_WEAPON_DAMAGE+",Synapse,0.0,0,DEPRECIATED,20,0.0,0.0,0.0,12,70,540,1.5,39,2.7,13,1,0.5",
PISTOL+","+CONTINUOUS+","+MAGNETIC_WEAPON_DAMAGE+",Synoid Gammacor,0,0,DEPRECIATED,20,0,0,0,12,80,400,1.8,20,2,28,1,0.5",
PISTOL+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Talons,0.0,0,DEPRECIATED,120,0,0,0,3.33,4,12,1,22,2,26,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Telos Akbolto,0.0,0,DEPRECIATED,0.0,4.7,42.3,0,10,30,210,2.6,13,2,29,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Telos Boltor,0.0,0,DEPRECIATED,0.0,3,27,0,9.33,90,540,2.4,30,2.4,16,1,1",
RIFLE+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Tenora,0,0,DEPRECIATED,0,7.2,9.6,7.2,11.67,150,900,2.5,28,2,16,1,1",
RIFLE+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Tenora (Secondary),0.8,0,DEPRECIATED,0,48,144,48,10,15,900,2.5,34,3,11,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Tetra,0.0,0,DEPRECIATED,0,6.4,25.6,0,6.67,60,540,2,4,1.5,20,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Tiberon,0.0,3,DEPRECIATED,0,11,22,11,9.09,30,540,2.3,26,2.4,16,1,1",
RIFLE+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Tiberon Prime (Burst),0.0,3,DEPRECIATED,46,13.8,18.4,13.8,7.38,42,540,2,28,3,20,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Tiberon Prime (Auto),0.0,0,DEPRECIATED,0.0,13.8,18.4,13.8,8.33,42,540,2,16,2.8,32,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Tiberon Prime (Semi),0.0,0,DEPRECIATED,0.0,13.8,18.4,13.8,6,42,540,2,30,3.4,18,1,1",
SHOTGUN+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Tigris,0.0,2,Blade and Whip,0.0,105,105,840,2,2,120,1.8,10,2,16.8,5,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
SHOTGUN+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Tigris Prime,0.0,4,Blade and Whip,0.0,156,156,1248,2,2,120,1.8,10,2,11.3,8,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Tonkor,0,0,DEPRECIATED,325,0,0,0,2,2,40,2,25,2.5,10,1,1",
RIFLE+","+SEMI_AUTO+","+TOXIN_WEAPON_DAMAGE+",Torid (Grenade),0,0,DEPRECIATED,400,0,0,0,1.5,5,60,1.7,15,2,23,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Twin Grakatas,0,0,Blade and Whip,0,8,6.7,5.3,20,60,1200,3,25,2.7,5.5,2,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Twin Gremlins,0.0,0,DEPRECIATED,0.0,12.33,12.33,12.33,5,30,210,1.1,15,1.5,15,1,1",
PISTOL+","+FULL_AUTO_BULLET_RAMP+","+PHYSICAL_WEAPON_DAMAGE+",Twin Kohmak,0.0,0,Blade and Whip,0.0,30,30,90,6.67,80,210,2.2,11,2,69,5,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Twin Rogga,0.0,0,Blade and Whip,0.0,282,352.5,70.5,2.5,2,210,1.5,10,2,6.6,15,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Twin Vipers,0.0,0,DEPRECIATED,0.0,10.2,1.7,5.1,25,28,210,2,15,1.5,11,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Twin Vipers Wraith,0.0,0,DEPRECIATED,0.0,14.4,1.8,1.8,25,40,440,2,19,2,9,1,1",
PISTOL+","+SEMI_AUTO+","+CORROSIVE_WEAPON_DAMAGE+",Tysis,0,0,DEPRECIATED,79,0,0,0,2.5,11,210,1.2,3,1.5,50,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Vasto,0,0,DEPRECIATED,0,14.5,14.5,29,5,6,210,1,20,1.8,8,1,1",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Vasto Prime,1,1,DEPRECIATED,156,9.9,9.9,46.2,5.42,6,210,1,22,2.4,22,1,1",
SHOTGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Vaykor Hek,0.0,0,Blade and Whip,0.0,78.75,341.25,105,3,8,120,2.25,25,2,10.7,7,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
PISTOL+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Vaykor Marelok,0.0,0,DEPRECIATED,0,96,16,48,2,10,210,1.67,20,1.5,35,1,1",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Vectis,0,0,DEPRECIATED,0,90,78.75,56.25,1.5,1,1,1,25,2,30,1,1,Headshot Dmg,30,50",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Vectis Prime,0.0,0,DEPRECIATED,0,140,157.5,52.5,2.67,2,5,0.85,30,2,30,1,1,Headshot Dmg,40,60",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Veldt,0.0,0,DEPRECIATED,0.0,23.4,23.4,43.2,3.67,16,528,1.8,22,2.2,22,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Viper,0,0,DEPRECIATED,0,10.2,1.7,5.1,14.38,14,210,0.7,15,1.5,11,1,1",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Viper Wraith,0,0,DEPRECIATED,0,14.4,1.8,1.8,14.38,20,210,0.8,19,2,9,1,1",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Vulkar,0,0,DEPRECIATED,0,180,33.8,11.2,1.5,6,2,3,20,2,25,1,1,Headshot Dmg,35,55,70",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Vulkar Wraith,0.0,0,DEPRECIATED,0.0,245.7,27.3,0,2,8,2,3,20,2,25,1,1,Headshot Dmg,35,55,70",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Wraith Twin Vipers,,,,,14.4,1.8,1.8,25,40,210,2,18,2,5,1,1",
PISTOL+","+SEMI_AUTO+","+GAS_WEAPON_DAMAGE+",Zakti (Gas Cloud),0,0,DEPRECIATED,80,0,0,0,5,3,210,0.8,2,1.5,20,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Zarr (Barrage Mode),0.0,0,Blade and Whip,0.0,240,400,160,3,3,84,2.3,17,2.5,2.9,10,1,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
RIFLE+","+SEMI_AUTO+","+BLAST_WEAPON_DAMAGE+",Zarr (With Bomblets),0,0,DEPRECIATED,475,0,0,0,1.67,3,84,2.3,17,2.5,29,1,1",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Zenith (Full-Auto),0.0,0,DEPRECIATED,0.0,4.5,6,19.5,10.83,90,540,1.4,10,2,34,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Zenith (Semi-Auto),0.0,0,DEPRECIATED,0.0,15,120,15,3,18,540,1.4,35,2.5,8,1,1",
RIFLE+","+AUTOBOW+","+PHYSICAL_WEAPON_DAMAGE+",Zhuge,0.0,0,DEPRECIATED,0.0,5,75,20,4.17,20,540,2.5,20,2,35,1,1",
PISTOL+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Zylok,0.0,2,DEPRECIATED,0,44.8,16.8,78.4,1.8,8,210,1.2,8,2,26,1,1",
PISTOL+","+CONTINUOUS+","+RADIATION_WEAPON_DAMAGE+",Cycron,0,0,DEPRECIATED,10,0,8,5,12,40,999,1,12,1.8,30,1,0.5",
RIFLE+","+SEMIBOW+","+PHYSICAL_WEAPON_DAMAGE+",Nagantaka,0,0,DEPRECIATED,0,1.6,14.3,143.1,2.5,9,540,2,15,2.3,39,1,1",
PISTOL+","+CONTINUOUS+","+RADIATION_WEAPON_DAMAGE+",Ocucor,0,0,DEPRECIATED,22,0,0,0,12,40,210,1.6,16,1.8,24,1,0.5",
RIFLE+","+BURST+","+MAGNETIC_WEAPON_DAMAGE+",Battacor,0.0,2,DEPRECIATED,42,0,24,0,3.57,60,540,2,32,2.4,18,1,1",
SHOTGUN+","+CONTINUOUS+","+RADIATION_WEAPON_DAMAGE+",Phantasma,0,0,Blade and Whip,50,25,0,0,12,11,0,0.5,3,1.5,7.4,5,0.5,null,null,null,null,0.0,0.0,0.0,0.0,No Element,0.0,No Element,No Element,0.0",
SHOTGUN+","+SEMI_AUTO+","+RADIATION_WEAPON_DAMAGE+",Exergis,0.0,0,DEPRECIATED,420,60,360,780,3.33,1,0,1.6,8,1.4,36,3,1,null,null,null,null,null,null,null,null,No Element,null,No Element,No Element,null",
PISTOL+","+SEMI_AUTO+","+FIRE_WEAPON_DAMAGE+",Plinx,0.0,0,DEPRECIATED,20,0,26,0,3.33,10,0,1,32,3,4,1,1",
RIFLE+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Opticor Vandal,0.6,0,DEPRECIATED,0.0,40,280,80,2,8,200,1.4,24,2.6,30,1,1",
RIFLE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Prisma Grinlok,0.0,0,DEPRECIATED,0.0,74.8,18.7,93.5,1.67,21,540,1.7,21,2.9,37,1,1",
ARCHGUN+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Corvas (Atmosphere Charged),0.5,0,DEPRECIATED,0.0,768,96,96,2,25,5,2,40,2.6,14,12,1",
ARCHGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Corvas (Atmosphere Uncharged),0.5,0,DEPRECIATED,0.0,384,46,46,2,25,5,2,40,2.6,14,12,1",
ARCHGUN+","+CHARGE+","+PHYSICAL_WEAPON_DAMAGE+",Corvas (Charged),0.5,0,DEPRECIATED,0.0,672,84,84,2,25,5,5,15,2,10,12,1",
ARCHGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Corvas (Uncharged),0.5,0,DEPRECIATED,0.0,336,42,42,2,25,5,5,15,2,10,12,1",
ARCHGUN+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Cyngas,0,3,DEPRECIATED,0,66,66,68,9.09,30,5,0.6,5,2,30,1,1",
ARCHGUN+","+BURST+","+PHYSICAL_WEAPON_DAMAGE+",Cyngas (Atmosphere),0,3,DEPRECIATED,0,39.6,39.6,40.8,9.09,30,5,1.2,20,2.2,30,1,1",
ARCHGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dual Decurion,0,0,DEPRECIATED,0,27,16.5,16.5,8.3,32,5,0.64,25,2,10,1,1",
ARCHGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dual Decurion (Atmosphere),0,0,DEPRECIATED,0,49.6,30.25,30.25,8.3,32,5,1.4,28,2.2,14,1,1",
ARCHGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Fluctus,0,0,DEPRECIATED,0,40,20,140,5,25,5,2.5,15,2,10,1,1",
ARCHGUN+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Fluctus (Atmosphere),0,0,DEPRECIATED,0,50,25,175,5,40,5,3,22,2,16,1,1",
ARCHGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Grattler,0,0,DEPRECIATED,0,27.5,220,27.5,6.25,60,5,6,25,2,25,1,1",
ARCHGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Grattler (Atmosphere),0,0,DEPRECIATED,0,29.7,237.8,29.7,6.25,30,5,2,25,2,25,1,1",
ARCHGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Imperator,0,0,DEPRECIATED,0,16,14,10,16.7,250,5,5,10,2,5,1,1",
ARCHGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Imperator (Atmosphere),0,0,DEPRECIATED,0,20,17.5,12.5,16.7,200,5,2,24,2,12,1,1",
ARCHGUN+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Imperator Vandal,0,0,DEPRECIATED,0,16,14,10,16.67,300,5,4,15,2,10,1,1",
ARCHGUN+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Imperator Vandal (Atmosphere),0,0,DEPRECIATED,0,20,17.5,12.5,25,300,5,2,28,2.4,12,1,1",
ARCHGUN+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Phaedra,0,0,DEPRECIATED,0,11.25,29.25,4.5,18.75,250,5,5,10,2,25,1,1",
ARCHGUN+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Phaedra (Atmosphere),0,0,DEPRECIATED,0,14,36.4,6,18.75,250,5,2,14,2,30,1,1",
ARCHGUN+","+CHARGE+","+MAGNETIC_WEAPON_DAMAGE+",Velocitus (Atmosphere Charged),1,0,DEPRECIATED,1200,0,0,0,5,10,5,2,30,3,25,1,1",
ARCHGUN+","+SEMI_AUTO+","+MAGNETIC_WEAPON_DAMAGE+",Velocitus (Atmosphere Uncharged),1,0,DEPRECIATED,133,0,0,0,5,10,5,2,30,3,25,1,1",
ARCHGUN+","+CHARGE+","+MAGNETIC_WEAPON_DAMAGE+",Velocitus (Charged),1,0,DEPRECIATED,1800,0,0,0,5,100,5,4,25,3,25,1,1",
ARCHGUN+","+SEMI_AUTO+","+MAGNETIC_WEAPON_DAMAGE+",Velocitus (Uncharged),1,0,DEPRECIATED,200,0,0,0,5,100,5,4,25,3,25,1,1",
ARCHGUN+","+CONTINUOUS+","+RADIATION_WEAPON_DAMAGE+",Larkspur,0,0,DEPRECIATED,80,10,0,0,12,600,0,12,10,1.4,50,1,1",
ARCHGUN+","+CONTINUOUS+","+RADIATION_WEAPON_DAMAGE+",Larkspur (Atmosphere),0,0,DEPRECIATED,80,10,0,0,12,100,0,2.5,10,1.4,50,1,1",
RIFLE+","+FULL_AUTO+","+ELECTRIC_WEAPON_DAMAGE+",Fulmin (Auto),0.0,0,Blade and Whip,25,8,0,0,9.33,60,0,1,28,2.4,10,1,0.5,null,null,null,null",
RIFLE+","+SEMI_AUTO+","+ELECTRIC_WEAPON_DAMAGE+",Fulmin (Slug),0.0,0,Blade and Whip,400,100,0,0,2.17,6,0,1,30,2.2,16,1,0,null,null,null,null",
PISTOL+","+FULL_AUTO+","+ELECTRIC_WEAPON_DAMAGE+",Quatz (Auto),0.0,0,Blade and Whip,11,9,2,7,15,72,0,2.7,13,1.5,27,1,0,null,null,null,null,0,0,0,0",
PISTOL+","+BURST+","+ELECTRIC_WEAPON_DAMAGE+",Quatz (Burst),0.0,4,Blade and Whip,11,9,2,7,10,72,0,2.7,27,2.5,19,1,0,null,null,null,null,0,0,0,0",
RIFLE+","+AUTOBOW+","+PHYSICAL_WEAPON_DAMAGE+",Zhuge Prime,0.0,0,Blade and Whip,0.0,21.2,26,42.3,5.5,30,540,3,26,2,30,1,1,null,null,null,null,0,0,0,0",
PISTOL+","+FULL_AUTO_RAMP_UP+","+PHYSICAL_WEAPON_DAMAGE+",Aksomati Prime,0.0,0,Blade and Whip,0.0,2,8,10,12.5,80,0,1.4,24,3,18,1,0,null,null,null,null,0,0,0,0",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Baza Prime,0.0,0,Blade and Whip,0.0,5.8,6.7,3.5,16.67,60,800,1.1,28,3,14,1,1,null,null,null,null,0,0,0,0",
RIFLE+","+FULL_AUTO+","+ICE_WEAPON_DAMAGE+",Quellor,0.0,0,Blade and Whip,16,8,22,12,6,300,0,4,12,1.6,38,1,0,null,null,null,null,0,0,0,0",
RIFLE+","+SEMI_AUTO+","+FIRE_WEAPON_DAMAGE+",Shedu,0.0,0,Blade and Whip,71,0,0,0,2.5,7,0,1,25,2.1,23,1,0,null,null,null,null,87,0,0,0,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+ELECTRIC_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",
SHOTGUN+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Astilla,0.0,0,Blade and Whip,0.0,70,0,0,4.33,16,0,2,17,1.9,33,1,0,null,null,null,null,0.0,0,42,78,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+PHYSICAL_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",
RIFLE+","+CHARGE+","+FIRE_WEAPON_DAMAGE+",Javlok,0.3,0,Blade and Whip,160,0,0,0,3.33,6,0,1.9,20,2,25,1,0,null,null,null,null,120,0,0,0,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+FIRE_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",
RIFLE+","+SNIPER+","+PHYSICAL_WEAPON_DAMAGE+",Komorex,0.3,0,Blade and Whip,0.0,17.4,73,83.6,1.5,20,5,3,16,2.1,35,1,0,Scoped CC,0,0,0,66,0,0,0,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+VIRAL_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",
PISTOL+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Cyanex,0.3,0,Blade and Whip,0.0,50,0,0,4.67,11,5,2.2,8,1.4,32,1,0,null,null,null,null,41,0,0,0,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+GAS_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",
RIFLE+","+FULL_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Acceltra,0.3,0,Blade and Whip,0.0,35,0,0,12,48,5,2,32,2.8,6,1,0,null,null,null,null,0.0,0,35.2,8.8,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+PHYSICAL_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",
RIFLE+","+FULL_AUTO+","+CORROSIVE_WEAPON_DAMAGE+",Scourge,0.3,0,Blade and Whip,70,0,0,0,2.67,40,5,2.5,2,1.5,30,1,0,null,null,null,null,55,0,0,0,"+PHYSICAL_WEAPON_DAMAGE+",0.0,"+CORROSIVE_WEAPON_DAMAGE+","+PHYSICAL_WEAPON_DAMAGE+",0.0",

//Melee
MELEE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dual Ether,0.0,0,Dual Swords,0.0,27,27,126,1,0,0,0.0,20,2,28,0,0,null,null,null,null,0,0,0,0",
MELEE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Dual Keres,0.0,0,Dual Swords,0.0,13.8,34.5,66.7,1.25,0,0,0.0,28,2.6,14,0,0,null,null,null,null,0,0,0,0",
MELEE+","+SEMI_AUTO+","+PHYSICAL_WEAPON_DAMAGE+",Nami Skyla Prime,0.0,0,Dual Swords,0.0,18,36,126,1.33,0,0,0.0,22,2,34,0,0,null,null,null,null,0,0,0,0"
};

public static final String[] stances = {
"Carving Mantis;Dual Swords;"
+ "Rapid Incisions:0.737,2.0,00000000000000,2.0:0.166,1.0,10000000000000,1.0:0.612,3.0,00000000000010,3.0:0.614,3.0,00000000100000,3.0:0.0,3.0,00000000000000,3.0:0.455,3.0,10000000000000,3.0:0.774,2.0,00000000000000,2.0:1.026,2.0,10000000000000,2.0:;"
+ "Ambush Predator:0.5,1.0,00000000000000,1.0:0.5,1.0,00000000000000,1.0:0.1,1.0,00000000000000,1.0:0.5,1.0,00000000000000,1.0:0.5,1.0,00000000000000,1.0:0.1,1.0,00000000000000,1.0:0.5,2.0,00000000100000,2.0:0.5,3.0,00000000000000,3.0:;"
+ "Biting Mandibles:1.25,1.0,00000000000000,1.0:0.0,1.0,00000000000000,1.0:0.0,1.0,00000000000000,1.0:0.0,1.0,00000000000000,1.0:0.9,2.0,00000000100000,2.0:0.3,2.0,10000000000000,2.0:0.7,4.0,00000000000010,4.0:;",
"Swirling Tiger;Dual Swords;"
+ "Winding Claws:0.14,1.0,00000000000000,1.0:0.09,1.0,00000000000000,1.0:0.09,1.0,00000000000000,1.0:0.14,1.0,00000000000000,1.0:0.05,1.0,00000000000000,1.0:0.15,1.0,10000000000000,1.0:0.25,3.0,10000000000000,3.0:0.67,1.0,00000000100000,1.0:0.07,3.0,00000000000010,3.0:0.33,1.0,00000000000000,1.0:;Twin Fang:;",
"Crossing Snakes;Dual Swords;"
+ "Twin Fang:0.55,1.0,00000000100000,1.0:0.0,1.0,00000000000010,1.0:0.48,1.0,10000000000000,1.0:0.37,1.0,10000000000000,1.0:0.82,1.0,00000000000010,1.0:0.14,1.0,00000000000000,1.0:;"

};

public static final String[] rifleDispositions = {
		"1.55, FLUX RIFLE",
		"1.55, HARPAK",
		"1.55, MITER",
		"1.55, MUTALIST QUANTA",
		"1.50, TETRA",
		"1.46, DETH MACHINE RIFLE",
		"1.46, DETH MACHINE RIFLE PRIME",
		"1.45, BUZLOK",
		"1.45, PRISMA TETRA",
		"1.45, VULKAR",
		"1.42, ATTICA",
		"1.42, HIND",
		"1.40, BURSTON",
		"1.40, GORGON",
		"1.40, LATRON",
		"1.40, MK1-PARIS",
		"1.40, PANTHERA",
		"1.40, QUANTA",
		"1.40, VULKAR WRAITH",
		"1.35, DERA",
		"1.35, GORGON WRAITH",
		"1.35, KARAK",
		"1.35, LATRON WRAITH",
		"1.35, MUTALIST CERNOS",
		"1.35, PARIS",
		"1.35, PENTA",
		"1.35, QUANTA VANDAL",
		"1.31, STINGER",
		"1.31, PARACYST",
		"1.31, SYNAPSE",
		"1.30, BRATON",
		"1.30, BURSTON PRIME",
		"1.30, DERA VANDAL",
		"1.30, GLAXION",
		"1.30, GRAKATA",
		"1.30, GRINLOK",
		"1.30, HEMA",
		"1.30, LATRON PRIME",
		"1.30, MK1-BRATON",
		"1.30, OGRIS",
		"1.30, PARIS PRIME",
		"1.30, PRISMA GORGON",
		"1.30, SECURA PENTA",
		"1.30, SNIPETRON",
		"1.30, TONKOR",
		"1.30, TORID",
		"1.28, KARAK WRAITH",
		"1.25, ARGONAK",
		"1.25, BRATON VANDAL",
		"1.25, CERNOS",
		"1.25, DAIKYU",
		"1.25, DREAD",
		"1.25, GLAXION VANDAL",
		"1.25, JAVLOK",
		"1.25, NAGANTAKA",
		"1.25, PRISMA GRAKATA",
		"1.25, PRISMA GRINLOK",
		"1.25, QUARTAKK",
		"1.25, SNIPETRON VANDAL",
		"1.25, VELDT",
		"1.25, VULKLOK",
		"1.21, LASER RIFLE",
		"1.21, PRIME LASER RIFLE",
		"1.20, BOLTOR",
		"1.20, BRATON PRIME",
		"1.20, CERNOS PRIME",
		"1.20, RAKTA CERNOS",
		"1.20, SIMULOR",
		"1.20, SYBARIS",
		"1.20, ZHUGE",
		"1.15, DEX SYBARIS",
		"1.15, FERROX",
		"1.15, SCOURGE",
		"1.15, SYNOID SIMULOR",
		"1.15, ZARR",
		"1.15, ZHUGE PRIME",
		"1.10, BOLTOR PRIME",
		"1.10, KOMOREX",
		"1.10, SYBARIS PRIME",
		"1.10, TELOS BOLTOR",
		"1.10, TENORA",
		"1.10, ZENITH",
		"1.05, OPTICOR",
		"1.05, STRADAVAR",
		"1.05, STRADAVAR PRIME",
		"1.00, ARTAX",
		"1.00, BATTACOR",
		"1.00, BAZA",
		"1.00, BAZA PRIME",
		"1.00, CRYOTRA",
		"1.00, KUVA CHAKKHURR",
		"1.00, KUVA KARAK",
		"1.00, KUVA OGRIS",
		"1.00, KUVA QUARTAKK",
		"1.00, KUVA TONKOR",
		"1.00, MULTRON",
		"1.00, OPTICOR VANDAL",
		"1.00, QUELLOR",
		"1.00, SHEDU",
		"1.00, SOMA",
		"1.00, SOMA PRIME",
		"1.00, TAZICOR",
		"1.00, VULCAX",
		"0.95, LENZ",
		"0.95, VECTIS",
		"0.90, LANKA",
		"0.90, SUPRA",
		"0.90, TIBERON",
		"0.85, SUPRA VANDAL",
		"0.85, TIBERON PRIME",
		"0.85, VECTIS PRIME",
		"0.80, ACCELTRA",
		"0.70, AMPREX",
		"0.70, RUBICO",
		"0.65, FULMIN",
		"0.65, RUBICO PRIME",
		"0.60, IGNIS",
		"0.55, IGNIS WRAITH"
};

public static final String[] pistolDispositions = {
		"1.53, KRAKEN",
		"1.53, MAGNUS",
		"1.52, AKLATO",
		"1.52, AKZANI",
		"1.52, CESTRA",
		"1.51, BOLTO",
		"1.51, KUNAI",
		"1.51, MK1-KUNAI",
		"1.50, SEER",
		"1.49, SPECTRA",
		"1.48, STUG",
		"1.45, AFURIS",
		"1.45, BURST LASER",
		"1.45, NUKOR",
		"1.45, PRISMA BURST LASER",
		"1.45, SPECTRA VANDAL",
		"1.45, TWIN VIPERS",
		"1.45, TYSIS",
		"1.44, TALONS",
		"1.41, TWIN VIPERS WRAITH",
		"1.40, BRONCO",
		"1.40, CASTANAS",
		"1.40, EMBOLIST",
		"1.40, LATO",
		"1.40, MK1-FURIS",
		"1.40, VASTO",
		"1.40, VIPER",
		"1.39, DEX FURIS",
		"1.35, AKBRONCO",
		"1.35, ANGSTRUM",
		"1.35, BRONCO PRIME",
		"1.35, DUAL CESTRA",
		"1.35, DUAL TOXOCYST",
		"1.35, FURIS",
		"1.35, KOHMAK",
		"1.35, LATO PRIME",
		"1.35, LATO VANDAL",
		"1.35, SANCTI CASTANAS",
		"1.35, STUBBA",
		"1.35, VASTO PRIME",
		"1.35, VIPER WRAITH",
		"1.33, ACRID",
		"1.30, AKBRONCO PRIME",
		"1.30, DESPAIR",
		"1.30, FUSILAI",
		"1.30, KULSTAR",
		"1.30, PRISMA ANGSTRUM",
		"1.30, SECURA DUAL CESTRA",
		"1.28, AKMAGNUS",
		"1.25, AKSOMATI",
		"1.25, AKVASTO",
		"1.25, AZIMA",
		"1.25, BRAKK",
		"1.25, KNELL",
		"1.25, TWIN KOHMAK",
		"1.25, TWIN ROGGA",
		"1.25, ZYLOK",
		"1.20, AKVASTO PRIME",
		"1.20, BALLISTICA",
		"1.20, CYCRON",
		"1.20, HIKOU",
		"1.20, SICARUS",
		"1.20, SPIRA",
		"1.20, TWIN GREMLINS",
		"1.20, ZAKTI",
		"1.15, BALLISTICA PRIME",
		"1.15, HIKOU PRIME",
		"1.15, HYSTRIX",
		"1.15, LEX",
		"1.15, OCUCOR",
		"1.15, PLINX",
		"1.15, PRISMA TWIN GREMLINS",
		"1.15, RAKTA BALLISTICA",
		"1.15, SPIRA PRIME",
		"1.15, TWIN GRAKATAS",
		"1.10, DETRON",
		"1.10, LEX PRIME",
		"1.10, SICARUS PRIME",
		"1.05, ARCA SCISCO",
		"1.05, GAMMACOR",
		"1.05, MARELOK",
		"1.05, PANDERO",
		"1.05, POX",
		"1.05, SONICOR",
		"1.00, AKARIUS",
		"1.00, AKSOMATI PRIME",
		"1.00, KUVA BRAKK",
		"1.00, KUVA KRAKEN",
		"1.00, KUVA SEER",
		"1.00, KUVA TWIN STUBBAS",
		"1.00, MARA DETRON",
		"1.00, QUATZ",
		"1.00, SYNOID GAMMACOR",
		"1.00, VAYKOR MARELOK",
		"0.95, AKBOLTO",
		"0.95, AKJAGARA",
		"0.90, AKLEX",
		"0.90, GAZE",
		"0.90, TELOS AKBOLTO",
		"0.85, AKBOLTO PRIME",
		"0.85, AKJAGARA PRIME",
		"0.80, AKLEX PRIME",
		"0.80, ATOMOS",
		"0.80, CYANEX",
		"0.70, EUPHONA PRIME",
		"0.70, PYRANA",
		"0.70, RATTLEGUTS",
		"0.65, TOMBFINGER",
		"0.60, AKSTILETTO",
		"0.60, PYRANA PRIME",
		"0.55, AKSTILETTO PRIME",
		"0.53, STATICOR",
		"0.50, CATCHMOON"
};

public static final String[] shotgunDispositions = {
		"1.48, DRAKGOON",
		"1.46, CONVECTRIX",
		"1.46, PHAGE",
		"1.45, MK1-STRUN",
		"1.40, BOAR",
		"1.40, KOHM",
		"1.40, STRUN",
		"1.35, STRUN WRAITH",
		"1.34, BOAR PRIME",
		"1.33, SOBEK",
		"1.10, ASTILLA",
		"1.10, HEK",
		"1.00, EXERGIS",
		"1.00, KUVA DRAKGOON",
		"1.00, KUVA KOHM",
		"1.00, PHANTASMA",
		"1.00, SWEEPER",
		"1.00, SWEEPER PRIME",
		"1.00, VAYKOR HEK",
		"0.95, CORINTH",
		"0.65, TIGRIS",
		"0.60, SANCTI TIGRIS",
		"0.55, ARCA PLASMOR",
		"0.55, TIGRIS PRIME"
};

public static final String[] ArchGunDispositions = {			
		"1.30, CYNGAS",
		"1.25, DUAL DECURION",
		"1.15, PHAEDRA",
		"1.05, CORVAS",
		"1.05, VELOCITUS",
		"1.00, KUVA AYANGA",
		"0.95, GRATTLER",
		"0.90, FLUCTUS",
		"0.85, IMPERATOR",
		"0.85, IMPERATOR VANDAL",
		"0.80, LARKSPUR"
};
}