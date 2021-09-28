package com.github.juliarn.npc.modifier;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.github.juliarn.npc.NPC;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class MovementModifier extends NPCModifier {

  /**
   * Creates a new modifier.
   *
   * @param npc The npc this modifier is for.
   * @see NPC#movement()
   */
  @ApiStatus.Internal
  public MovementModifier(@NotNull NPC npc) {
    super(npc);
  }

  /**
   * Queues the animation to be played.
   *
   * @param location The animation to play.
//   * @param teleport
   * @return The same instance of this class, for chaining.
   */
  @NotNull
  public MovementModifier queue(@NotNull Location location/*, boolean teleport*/) {
    PacketContainer entityTeleportContainer = super
        .newContainer(PacketType.Play.Server.ENTITY_TELEPORT);
    entityTeleportContainer.getModifier().writeDefaults();
    entityTeleportContainer.getDoubles().write( 0, location.getX() );
    entityTeleportContainer.getDoubles().write( 1, location.getY() );
    entityTeleportContainer.getDoubles().write( 2, location.getZ() );

    return this;
  }
}
