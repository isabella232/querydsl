package com.mysema.query.jpa.domain.sql;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;


/**
 * SFoo is a Querydsl query type for SFoo
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class SFoo extends com.mysema.query.sql.RelationalPathBase<SFoo> {

    private static final long serialVersionUID = -1389443894;

    public static final SFoo foo_ = new SFoo("foo_");

    public final StringPath bar = createString("bar");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DatePath<java.sql.Date> startDate = createDate("startDate", java.sql.Date.class);

    public final com.mysema.query.sql.PrimaryKey<SFoo> primary = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<SFooNames> _fkb6129a8f94e297f8 = createInvForeignKey(id, "foo_id");

    public SFoo(String variable) {
        super(SFoo.class, forVariable(variable), "null", "foo_");
        addMetadata();
    }

    public SFoo(String variable, String schema, String table) {
        super(SFoo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public SFoo(Path<? extends SFoo> path) {
        super(path.getType(), path.getMetadata(), "null", "foo_");
        addMetadata();
    }

    public SFoo(PathMetadata<?> metadata) {
        super(SFoo.class, metadata, "null", "foo_");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(bar, ColumnMetadata.named("bar").withIndex(2).ofType(12).withSize(255));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(4).withSize(10).notNull());
        addMetadata(startDate, ColumnMetadata.named("startDate").withIndex(3).ofType(91).withSize(10));
    }

}

