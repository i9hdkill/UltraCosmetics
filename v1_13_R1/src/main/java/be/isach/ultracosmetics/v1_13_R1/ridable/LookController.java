package be.isach.ultracosmetics.v1_13_R1.ridable;

import net.minecraft.server.v1_13_R1.ControllerLook;
import net.minecraft.server.v1_13_R1.EntityInsentient;
import net.minecraft.server.v1_13_R1.EntityPlayer;

/**
 * @author BillyGalbreath
 * <p>
 * Author of plugin: "Ridables"
 * Thanks for authorizing using Ridables code to make UC work!
 */
public class LookController extends ControllerLook {
    protected final RidableEntity ridable;
    private float yawOffset = 0;
    private float pitchOffset = 0;

    public LookController(RidableEntity ridable) {
        super((EntityInsentient) ridable);
        this.ridable = ridable;
    }

    public void setYawPitch(float yaw, float pitch) {
        a.aS = a.aQ = a.lastYaw = a.yaw = (yaw + yawOffset) % 360.0F;
        a.pitch = (pitch + pitchOffset) % 360.0F;
    }

    public void setOffsets(float yaw, float pitch) {
        yawOffset = yaw;
        pitchOffset = pitch;
    }

    // tick
    @Override
    public void a() {
        if (ridable.getRider() != null) {
            tick(ridable.getRider());
        } else {
            tick();
        }
    }

    public void tick(EntityPlayer rider) {
        setYawPitch(rider.yaw, rider.pitch * 0.5F);
    }

    public void tick() {
        super.a();
    }
}