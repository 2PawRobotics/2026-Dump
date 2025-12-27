package frc.robot.commands.drivetrain;

public class OrbitCmd extends PointCmd {
    public OrbitCmd(frc.robot.subsystems.SwerveSys swerveSys) {
        super(swerveSys);
    }

    @Override
    public void execute() {
        // Get the horizontal offset (tx) from the limelight
        double tx = frc.robot.util.limelight.LimelightHelpers.getTX("limelight");

        // Calculate the rotational speed to orbit around the target
        double rotationSpeed = 0.1 * tx;

        // Limit the rotation speed to avoid excessive movement
        rotationSpeed = Math.max(-7.5, Math.min(7.5, rotationSpeed));

        // Command the swerve drive to orbit (move forward while rotating)
        swerveSys.drive(0.5, 0, -rotationSpeed, false); // Move forward at a constant speed
    }
    
}
