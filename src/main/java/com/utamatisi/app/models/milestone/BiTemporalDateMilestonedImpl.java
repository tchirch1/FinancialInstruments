package com.utamatisi.app.models.milestone;

import com.utamatisi.app.util.DateUtil;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by titus.chirchir12
 * Date Created 1/25/2016.
 * Package: ${PACKAGE}
 */
public class BiTemporalDateMilestonedImpl implements BusinessDateMilestoned, ProcessingDateMilestoned
{

    @Column(name = "out_z")
    private Timestamp businessDateTo;

    @Column(name = "in_z")
    private Timestamp businessDateFrom;

    @Column(name = "from_z")
    private Timestamp processingDateFrom;
    @Column(name = "thru_z")
    private Timestamp processingDateTo;

    public BiTemporalDateMilestonedImpl(Timestamp processingDateFrom)
    {
        this.processingDateFrom = processingDateFrom;
        this.processingDateTo = DateUtil.INFINITY_PROCESSING_DATE;
        this.businessDateFrom = new Timestamp(new Date().getTime());
        this.businessDateTo = DateUtil.INFINITY_BUSINESSDATE;
    }

    @Override
    public Timestamp getBusinessDateFrom()
    {
        return this.businessDateFrom;
    }

    public void setBusinessDateFrom(Timestamp businessDateFrom)
    {
        this.businessDateFrom = businessDateFrom;
    }

    @Override
    public Timestamp getBusinessDateTo()
    {
        return this.businessDateTo;
    }

    public void setBusinessDateTo(Timestamp businessDateTo)
    {
        this.businessDateTo = businessDateTo;
    }

    @Override
    public Timestamp getProcessingDateFrom()
    {
        return this.processingDateFrom;
    }

    public void setProcessingDateFrom(Timestamp processingDateFrom)
    {
        this.processingDateFrom = processingDateFrom;
    }

    @Override
    public Timestamp getProcessingDateTo()
    {
        return this.processingDateTo;
    }

    public void setProcessingDateTo(Timestamp processingDateTo)
    {
        this.processingDateTo = processingDateTo;
    }

}
