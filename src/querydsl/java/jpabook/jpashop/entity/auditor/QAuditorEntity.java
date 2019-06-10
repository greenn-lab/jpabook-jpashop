package jpabook.jpashop.entity.auditor;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditorEntity is a Querydsl query type for AuditorEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAuditorEntity extends EntityPathBase<AuditorEntity> {

    private static final long serialVersionUID = 395998093L;

    public static final QAuditorEntity auditorEntity = new QAuditorEntity("auditorEntity");

    public final DateTimePath<java.time.LocalDateTime> created = createDateTime("created", java.time.LocalDateTime.class);

    public final StringPath creator = createString("creator");

    public final DateTimePath<java.time.LocalDateTime> updated = createDateTime("updated", java.time.LocalDateTime.class);

    public final StringPath updater = createString("updater");

    public QAuditorEntity(String variable) {
        super(AuditorEntity.class, forVariable(variable));
    }

    public QAuditorEntity(Path<? extends AuditorEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditorEntity(PathMetadata metadata) {
        super(AuditorEntity.class, metadata);
    }

}

