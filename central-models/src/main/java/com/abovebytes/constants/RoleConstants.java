package com.abovebytes.constants;


import com.abovebytes.enums.RoleValue;

import java.util.List;

public class RoleConstants {
    public static final List<String> DEFAULT_OPERATIONAL_ROLES = List.of(
            RoleValue.HOUSE_REGISTERER.name(), RoleValue.POLICE.name(), RoleValue.SUPERVISOR.name(),
            RoleValue.VEHICLE_REGISTERER.name(), RoleValue.VIEWER.name(), RoleValue.ROAD_POLICE.name(), RoleValue.SUPER_ADMIN.name()
    );
//        "SUPER_ADMIN", "MEDICAL_CORP"

}
