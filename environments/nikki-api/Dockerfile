FROM mcr.microsoft.com/dotnet/sdk:9.0.308-bookworm-slim AS build
WORKDIR /App

COPY .config/ .config/
COPY paket.dependencies paket.lock ./
COPY nikki-api.sln ./
COPY NikkiApi/NikkiApi.fsproj ./NikkiApi/
COPY NikkiApi.Test/NikkiApi.Test.fsproj ./NikkiApi.Test/

RUN --mount=type=cache,id=nuget,target=/root/.nuget/packages \
    --mount=type=cache,id=paket,target=/root/.paket \
    dotnet tool restore && \
    dotnet paket restore && \
    dotnet restore

COPY . ./

RUN --mount=type=cache,id=nuget,target=/root/.nuget/packages \
    dotnet publish NikkiApi/NikkiApi.fsproj \
        -c Release \
        -o out \
        --no-restore

FROM mcr.microsoft.com/dotnet/aspnet:9.0-bookworm-slim
WORKDIR /App

COPY --from=build /App/out .

USER $APP_USER

EXPOSE 8080

ENTRYPOINT ["dotnet", "NikkiApi.dll"]