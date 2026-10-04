package ru.lolo.seasons.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.lolo.seasons.LoloSeasons;
import ru.lolo.seasons.block.ModBlocks;
import ru.lolo.seasons.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LoloSeasons.MODID);

    // ---------- Материалы ----------
    public static final DeferredItem<Item> SPARK_SHARD = ITEMS.register("spark_shard",
            () -> new LoloItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> TIME_FRAGMENT = ITEMS.register("time_fragment",
            () -> new LoloItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> ARCHEY_INGOT = ITEMS.register("archey_ingot",
            () -> new LoloItem(new Item.Properties()));
    public static final DeferredItem<Item> EMBER = ITEMS.register("thirteen_fires_ember",
            () -> new LoloItem(new Item.Properties()));

    // ---------- Инструменты Архея ----------
    public static final Tier ARCHEY_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            900, 7.0F, 2.5F, 16, () -> Ingredient.of(ModItems.ARCHEY_INGOT.get()));

    public static final DeferredItem<Item> ARCHEY_SWORD = ITEMS.register("archey_sword",
            () -> new SwordItem(ARCHEY_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ARCHEY_TIER, 3, -2.4F))));
    public static final DeferredItem<Item> ARCHEY_PICKAXE = ITEMS.register("archey_pickaxe",
            () -> new PickaxeItem(ARCHEY_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ARCHEY_TIER, 1.0F, -2.8F))));

    // ---------- Особые предметы из сезонов ----------
    public static final DeferredItem<Item> SPARK_STAFF = ITEMS.register("spark_staff",
            () -> new SparkStaffItem(new Item.Properties().stacksTo(1).durability(240).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> TIME_CLOCK = ITEMS.register("time_clock",
            () -> new TimeClockItem(new Item.Properties().stacksTo(1).durability(24).rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> SMARTPHONE = ITEMS.register("smartphone",
            () -> new SmartphoneItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SCARAB_AMULET = ITEMS.register("scarab_amulet",
            () -> new ScarabAmuletItem(new Item.Properties().stacksTo(1).durability(12).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RUBBER_DUCK = ITEMS.register("rubber_duck",
            () -> new RubberDuckItem(new Item.Properties().stacksTo(16)));

    // ---------- Блоки (предметы) ----------
    public static final DeferredItem<BlockItem> ARCHEY_ORE_ITEM = ITEMS.registerSimpleBlockItem("archey_ore", ModBlocks.ARCHEY_ORE);
    public static final DeferredItem<BlockItem> ARCHEY_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("archey_block", ModBlocks.ARCHEY_BLOCK);
    public static final DeferredItem<BlockItem> BRAZIER_ITEM = ITEMS.registerSimpleBlockItem("thirteen_fires_brazier", ModBlocks.BRAZIER);

    // ---------- Яйца призыва NPC ----------
    public static final DeferredItem<Item> WANDERER_SPAWN_EGG = ITEMS.register("wanderer_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.WANDERER, 0x1B2A49, 0x4FD6FF, new Item.Properties()));
    public static final DeferredItem<Item> AUTOMATON_SPAWN_EGG = ITEMS.register("automaton_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.AUTOMATON, 0x8A9099, 0xFFC93C, new Item.Properties()));
}
