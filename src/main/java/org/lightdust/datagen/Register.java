package org.lightdust.datagen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {
    
    private static List<String> getList(Set<Identifier> Id) {
        return Id.stream().map(Identifier::getPath).sorted().toList();
    }

    public static void run() {
        Map<String, Set<Identifier>> M = new HashMap<>();
        M.put("Item", Registry.ITEM.getIds());
        M.put("Fluid", Registry.FLUID.getIds());
        M.put("Block", Registry.BLOCK.getIds());
        M.put("EntityType", Registry.ENTITY_TYPE.getIds());
        M.put("Potion", Registry.POTION.getIds());
        M.put("SoundEvent", Registry.SOUND_EVENT.getIds());
        M.put("StatusEvent", Registry.STATUS_EFFECT.getIds());
        M.put("Enchantment", Registry.ENCHANTMENT.getIds());
        M.put("ParticleType", Registry.PARTICLE_TYPE.getIds());
        M.put("BlockEntityType", Registry.BLOCK_ENTITY_TYPE.getIds());
        M.put("Custom_Stat", Registry.CUSTOM_STAT.getIds());
        M.put("Attribute", Registry.ATTRIBUTE.getIds());
        M.put("ChunkStatus", Registry.CHUNK_STATUS.getIds());
        M.put("RecipeType", Registry.RECIPE_TYPE.getIds());
        M.put("LootPoolEntryType", Registry.LOOT_POOL_ENTRY_TYPE.getIds());
        M.put("LootFunctionType", Registry.LOOT_FUNCTION_TYPE.getIds());
        M.put("LootConditionType", Registry.LOOT_CONDITION_TYPE.getIds());
        M.put("LootNumberProviderType", Registry.LOOT_NUMBER_PROVIDER_TYPE.getIds());
        M.put("LootNbtProviderType", Registry.LOOT_NBT_PROVIDER_TYPE.getIds());
        M.put("LootScoreProviderType", Registry.LOOT_SCORE_PROVIDER_TYPE.getIds());
        for (Entry<String, Set<Identifier>> entry : M.entrySet()) {
            String txt = "from utils.enum import Enum" + Tools.getEnum(getList(entry.getValue()), entry.getKey()) +
                    "\n";
            FileTool.Write("./gens/%s.py".formatted(entry.getKey()), txt);
        }
        DataGetter.LOGGER.info("data loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.exit(0);
    }
}
