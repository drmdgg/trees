package drmdgg.marijuanacraft.init.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class PotPlant extends BigTree {
	   @Nullable
	   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
	      return new BasicTreeFeature(NoFeatureConfig::deserialize, true, false);
	   }

	   @Nullable
	   protected AbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
	      return new BasicTreeFeature(NoFeatureConfig::deserialize, false, random.nextBoolean());
	   }

}