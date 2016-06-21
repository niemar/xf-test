/*1. Select countries where a total number of inhabitants (population) in all cities is greater
	than 400.*/
select XF.Country.Name, sum(XF.City.Population) as Inhabitants from XF.Country 
inner join XF.City on XF.Country.CountryID = XF.City.CountryID
group by XF.Country.CountryID 
having sum(XF.City.Population) > 400;

/* 2. Select names of the countries that have no buildings at all. 
	dlaczego left*/
select XF.Country.Name, count(XF.Building.BuildingID) as Buildings_count from XF.Country 
inner join XF.City on XF.Country.CountryID = XF.City.CountryID
left join XF.Building on XF.City.CityID = XF.Building.CityID 
group by XF.Country.CountryID 
having count(XF.Building.BuildingID) = 0;
