package org.lightdust.datagen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class register {
    
    private static List<String> getList(Set<Identifier> Id) {
        return Id.stream().map(Identifier::getPath).sorted().toList();
    }

    public static void run() {
        Map<String, Set<Identifier>> M = new HashMap<String, Set<Identifier>>();
        M.put("MCItem", Registry.ITEM.getIds());
        M.put("MCFluid", Registry.FLUID.getIds());
        M.put("MCBlock", Registry.BLOCK.getIds());
        M.put("MCEntityType", Registry.ENTITY_TYPE.getIds());
        M.put("MCPotion", Registry.POTION.getIds());
        M.put("MCSoundEvent", Registry.SOUND_EVENT.getIds());
        M.put("MCStatusEvent", Registry.STATUS_EFFECT.getIds());
        M.put("MCEnchantment", Registry.ENCHANTMENT.getIds());
        M.put("MCParticleType", Registry.PARTICLE_TYPE.getIds());
        M.put("MCBlockEntityType", Registry.BLOCK_ENTITY_TYPE.getIds());
        M.put("MCCustom_Stat", Registry.CUSTOM_STAT.getIds());
        M.put("MCAttribute", Registry.ATTRIBUTE.getIds());
        M.put("MCChunkStatus", Registry.CHUNK_STATUS.getIds());
        M.put("MCPaintingMotive", Registry.PAINTING_MOTIVE.getIds());
        for (Entry<String, Set<Identifier>> entry : M.entrySet()) {
            String txt = tools.getEnum(getList(entry.getValue()), entry.getKey());
            FileTool.Write("./gens/%s.ts".formatted(entry.getKey()), txt);
        }
        dataGetter.LOGGER.info("data loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
