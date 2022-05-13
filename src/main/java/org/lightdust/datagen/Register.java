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
        M.put("PaintingMotive", Registry.PAINTING_MOTIVE.getIds());
        M.put("RecipeType", Registry.RECIPE_TYPE.getIds());
        StringBuilder txt = new StringBuilder("from utils.enum import enum");
        for (Entry<String, Set<Identifier>> entry : M.entrySet()) {
            txt.append(Tools.getEnum(getList(entry.getValue()), entry.getKey()));
        }
        txt.append("\n");
        FileTool.Write("./gens/MinecraftEnum.py", txt.toString());
        DataGetter.LOGGER.info("data loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.exit(0);
    }
}
