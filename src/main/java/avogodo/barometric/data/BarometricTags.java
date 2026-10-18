package avogodo.barometric.data;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BarometricTags {
    public static final TagKey<EntityType<?>> WIND_IMMUE_ENTITIES = TagKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of("barometric", "wind_immune_entities")
    );}
