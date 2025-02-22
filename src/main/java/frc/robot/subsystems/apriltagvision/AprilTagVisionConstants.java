// Copyright (c) 2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by an MIT-style
// license that can be found in the LICENSE file at
// the root directory of this project.

package frc.robot.subsystems.apriltagvision;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.util.Units;

// Constants related to AprilTag vision processing and camera configuration for the robot
public class AprilTagVisionConstants {
    // Threshold for determining if there is ambiguity in the detected AprilTag
    public static final double ambiguityThreshold = 0.2;
    // Time interval for logging target information in seconds
    public static final double targetLogTimeSecs = 0.1;
    // Margin to avoid field borders in meters
    public static final double fieldBorderMargin = 0.5;
    // Margin along the Z-axis for detecting targets in meters
    public static final double zMargin = 0.75;
    // Coefficient for calculating standard deviation in X and Y position estimates
    public static final double xyStdDevCoefficient = 0.005;
    // Coefficient for calculating standard deviation in theta (rotation) estimate
    public static final double thetaStdDevCoefficient = 0.01;

    // Factors used for scaling standard deviations in the camera measurements
    public static final double[] stdDevFactors = new double[]{1.0, 1, 1.0, 1};

    // Array of camera poses relative to the robot's coordinate system
    public static final Pose3d[] cameraPoses =
            new Pose3d[]{
                    new Pose3d(
                            -0.190,
                            -0.045,
                            0.22,
                            new Rotation3d(0.0, Units.degreesToRadians(-20), 0.0)
                                    .rotateBy(new Rotation3d(0.0, 0.0, Units.degreesToRadians(180)))),
                    new Pose3d(
                            0.127,
                            -0.247,
                            0.209,
                            new Rotation3d(0.0, Units.degreesToRadians(-20), 0.0)
                                    .rotateBy(new Rotation3d(0.0, 0.0, Units.degreesToRadians(225)))),
                    new Pose3d(
                            Units.inchesToMeters(8.875),
                            Units.inchesToMeters(-10.5),
                            Units.inchesToMeters(8.25),
                            new Rotation3d(0.0, Units.degreesToRadians(-28.125), 0.0)
                                    .rotateBy(new Rotation3d(0.0, 0.0, Units.degreesToRadians(-30.0)))),
                    new Pose3d(
                            Units.inchesToMeters(-16.0),
                            Units.inchesToMeters(-12.0),
                            Units.inchesToMeters(8.5),
                            new Rotation3d(0.0, Units.degreesToRadians(-33.75), 0.0)
                                    .rotateBy(new Rotation3d(0.0, 0.0, Units.degreesToRadians(176.386))))
            };

    // Instance names for the installed AprilTag vision cameras
    public static final String[] instanceNames =
            new String[]{"northstar_0", "northstar_1", "northstar_2", "northstar_3"};

    // Camera device IDs for the installed AprilTag vision cameras
    public static final String[] cameraIds =
            new String[]{
                    "/dev/video_cam3",
                    "/dev/video_cam2",
                    "/dev/v4l/by-path/platform-fc800000.usb-usb-0:1:1.0-video-index0",
                    "/dev/v4l/by-path/platform-fc880000.usb-usb-0:1:1.0-video-index0"
            };
}