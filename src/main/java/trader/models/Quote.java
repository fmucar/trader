package trader.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quotes")
public class Quote {
	
	public static final String PROPERTY_SYMBOL_ID = "symbol";
	public static final String PROPERTY_NAME = "name";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Version
    private Long version;
	
	@NotNull
	@Column(unique = true)
	private String symbol;
	
	@NotNull
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private QuoteCategory category;
	
	@ManyToOne
	private Market market;
	
	@NotNull
	private String chartSrc;
	
	@NotNull
	private String tickerSrc;
	
	@NotNull
	private String quoteSrc;
	
	@NotNull
	private Integer payout;
	
	@NotNull
	private Boolean enabled;

	public Quote(String symbol, String name, QuoteCategory category, Market market, String chartSrc, String tickerSrc, String quoteSrc,
			Integer payout) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.category = category;
		this.market = market;
		this.chartSrc = chartSrc;
		this.tickerSrc = tickerSrc;
		this.quoteSrc = quoteSrc;
		this.payout = payout;
		this.enabled = true;
	}
	
	public Quote() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuoteCategory getCategory() {
		return category;
	}

	public void setCategory(QuoteCategory category) {
		this.category = category;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public String getChartSrc() {
		return chartSrc;
	}

	public void setChartSrc(String chartSrc) {
		this.chartSrc = chartSrc;
	}
	
	public String getTickerSrc() {
		return tickerSrc;
	}

	public void setTickerSrc(String tickerSrc) {
		this.tickerSrc = tickerSrc;
	}

	public String getQuoteSrc() {
		return quoteSrc;
	}

	public void setQuoteSrc(String quoteSrc) {
		this.quoteSrc = quoteSrc;
	}

	public Integer getPayout() {
		return payout;
	}

	public void setPayout(Integer payout) {
		this.payout = payout;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
}
