package com.abovebytes.dtos.user;

import com.abovebytes.dtos.habitattion.HabitationDTO;
import com.abovebytes.enums.Gender;
import com.abovebytes.enums.Status;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InviteDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long inviteId;
    private String phone;
    private String code;
    private String title;
    private String firstName;
    private String lastName;
    private String message;
    private boolean accepted;
    private boolean liveInSameHouse;
    private boolean isOwner;
    private LocalDateTime acceptationDateAndTime;

    private HabitationDTO habitation;

    private Long invitedBy;
    private Status status;
    private Gender gender;

    private LocalDateTime createDate;
    private LocalDateTime lastModified;
}