package com.trusthiker.common.db.bas.model;

import com.trusthiker.common.db.model.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "T_EVE_EVENT_PROCESS")
@EqualsAndHashCode(callSuper=false)
public class EventProcess extends Entity {

    private static final long serialVersionUID = -5227564951878481064L;


}
