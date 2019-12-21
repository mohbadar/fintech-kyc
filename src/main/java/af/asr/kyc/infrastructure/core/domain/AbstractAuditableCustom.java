//
//package af.asr.kyc.infrastructure.core.domain;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.joda.time.DateTime;
//import org.springframework.data.domain.Auditable;
//import org.springframework.data.jpa.domain.AbstractAuditable;
//
///**
// * A custom copy of {@link AbstractAuditable} to override the column names used
// * on database.
// *
// * Abstract base class for auditable entities. Stores the audition values in
// * persistent fields.
// *
// * @param <U>
// *            the auditing type. Typically some kind of user.
// * @param <PK>
// *            the type of the auditing type's identifier
// */
//@MappedSuperclass
//public abstract class AbstractAuditableCustom<U, PK extends Serializable> extends AbstractPersistableCustom<PK> implements Auditable<AppUser, Long> {
//
//    private static final long serialVersionUID = 141481953116476081L;
//
//    @OneToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "createdby_id")
//    private AppUser createdBy;
//
//    @Column(name = "created_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @OneToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "lastmodifiedby_id")
//    private AppUser lastModifiedBy;
//
//    @Column(name = "lastmodified_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see org.springframework.data.domain.Auditable#getCreatedBy()
//     */
//    @Override
//    public AppUser getCreatedBy() {
//
//        return this.createdBy;
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see
//     * org.springframework.data.domain.Auditable#setCreatedBy(java.lang.Object)
//     */
//    @Override
//    public void setCreatedBy(final AppUser createdBy) {
//
//        this.createdBy = createdBy;
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see org.springframework.data.domain.Auditable#getCreatedDate()
//     */
//    @Override
//    public DateTime getCreatedDate() {
//
//        return null == this.createdDate ? null : new DateTime(this.createdDate);
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see
//     * org.springframework.data.domain.Auditable#setCreatedDate(org.joda.time
//     * .DateTime)
//     */
//    @Override
//    public void setCreatedDate(final DateTime createdDate) {
//
//        this.createdDate = null == createdDate ? null : createdDate.toDate();
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see org.springframework.data.domain.Auditable#getLastModifiedBy()
//     */
//    @Override
//    public AppUser getLastModifiedBy() {
//
//        return this.lastModifiedBy;
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see
//     * org.springframework.data.domain.Auditable#setLastModifiedBy(java.lang
//     * .Object)
//     */
//    @Override
//    public void setLastModifiedBy(final AppUser lastModifiedBy) {
//
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see org.springframework.data.domain.Auditable#getLastModifiedDate()
//     */
//    @Override
//    public DateTime getLastModifiedDate() {
//
//        return null == this.lastModifiedDate ? null : new DateTime(this.lastModifiedDate);
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see
//     * org.springframework.data.domain.Auditable#setLastModifiedDate(org.joda
//     * .time.DateTime)
//     */
//    @Override
//    public void setLastModifiedDate(final DateTime lastModifiedDate) {
//
//        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
//    }
//}
