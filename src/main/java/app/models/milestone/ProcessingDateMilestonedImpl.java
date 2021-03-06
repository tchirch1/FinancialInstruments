package app.models.milestone;

import app.util.DateUtil;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * Created by titus.chirchir12
 * Date Created 1/25/2016.
 * Package: ${PACKAGE}
 */
public class ProcessingDateMilestonedImpl implements ProcessingDateMilestoned
{

    @Column(name = "from_z")
    private Timestamp processingDateFrom;
    @Column(name = "thru_z")
    private Timestamp processingDateTo;

    public ProcessingDateMilestonedImpl(Timestamp processingDateFrom)
    {
        this.processingDateTo = DateUtil.INFINITY_PROCESSING_DATE;
        this.processingDateFrom = processingDateFrom;
    }

    @Override
    public Timestamp getProcessingDateFrom()
    {
        return this.processingDateFrom;
    }

    @Override
    public Timestamp getProcessingDateTo()
    {
        return this.processingDateTo;
    }

    @Override
    public void setProcessingDateTo(Timestamp processingDateTo)
    {
        this.processingDateTo = processingDateTo;
    }
}
