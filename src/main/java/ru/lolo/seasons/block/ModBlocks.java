package ru.lolo.seasons.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.lolo.seasons.LoloSeasons;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LoloSeasons.MODID);

    public static final DeferredBlock<Block> ARCHEY_ORE = BLOCKS.register("archey_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ARCHEY_BLOCK = BLOCKS.registerSimpleBlock("archey_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL));

    public static final DeferredBlock<BrazierBlock> BRAZIER = BLOCKS.registerBlock("thirteen_fires_brazier",
            BrazierBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(3.5F)
                    .requiresCorrectToolForDrops().sound(SoundType.LANTERN).lightLevel(state -> 13).noOcclusion());
}
